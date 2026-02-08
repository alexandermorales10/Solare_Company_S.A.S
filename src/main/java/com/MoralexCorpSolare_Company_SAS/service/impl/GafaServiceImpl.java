package com.MoralexCorpSolare_Company_SAS.service.impl;

import com.MoralexCorpSolare_Company_SAS.entity.Gafas;
import com.MoralexCorpSolare_Company_SAS.repository.GafasRepository;
import com.MoralexCorpSolare_Company_SAS.service.GafasService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GafaServiceImpl implements GafasService {

    private final GafasRepository gafasRepository;

    public GafaServiceImpl(GafasRepository gafasRepository) {
        this.gafasRepository = gafasRepository;
    }

    @Override
    public Gafas save(Gafas gafas){
        return gafasRepository.save(gafas);
    }

    @Override
    public List<Gafas> findAll() {
        return gafasRepository.findAll();
    }

    @Override
    public List<Gafas> findMarca(String marca) {
        return gafasRepository.findByMarca(marca);
    }

    @Override
    public List<Gafas> findAvailable() {
        return gafasRepository.findByActiveTrue();
    }

    @Override
    public Gafas findById(Long id) {
        return gafasRepository.findById(id).orElseThrow(()-> new RuntimeException(" Gafas no encontradas "));
    }

    @Override
    public void eliminar(Long id) {
        gafasRepository.deleteById(id);
    }

    @Override
    public void restarStock(Long id, Integer cantidad) {

        Gafas gafas = gafasRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Gafas no encontradas"));
        if(gafas.getStock()< cantidad){
            throw new RuntimeException("Stock insuficiente ");
        }
        gafas.setStock(gafas.getStock() - cantidad);
        gafasRepository.save(gafas);
    }
}
