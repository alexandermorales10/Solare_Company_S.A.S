package com.MoralexCorpSolare_Company_SAS.service;

import com.MoralexCorpSolare_Company_SAS.entity.Gafas;

import java.util.List;

public interface GafasService {
    Gafas save(Gafas gafas);
    List<Gafas> findAll();
    List<Gafas> findMarca(String marca);
    List<Gafas> findAvailable();
    Gafas findById(Long id);
    void eliminar(Long id);
    void restarStock(Long id, Integer cantidad);
}
