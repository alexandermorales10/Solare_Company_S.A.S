package com.MoralexCorpSolare_Company_SAS.service.impl;

import com.MoralexCorpSolare_Company_SAS.dto.PagoRequestDTO;
import com.MoralexCorpSolare_Company_SAS.dto.PagoResponseDTO;
import com.MoralexCorpSolare_Company_SAS.entity.Gafas;
import com.MoralexCorpSolare_Company_SAS.entity.Pago;
import com.MoralexCorpSolare_Company_SAS.exception.BadRequestException;
import com.MoralexCorpSolare_Company_SAS.exception.ResourceNotFoundException;
import com.MoralexCorpSolare_Company_SAS.integration.wompi.WompiClient;
import com.MoralexCorpSolare_Company_SAS.mapper.PagoMapper;
import com.MoralexCorpSolare_Company_SAS.repository.PagoRepository;
import com.MoralexCorpSolare_Company_SAS.service.GafasService;
import com.MoralexCorpSolare_Company_SAS.service.PagoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final GafasService gafasService;
    private final WompiClient wompiClient;

    public PagoServiceImpl(
            PagoRepository pagoRepository,
            GafasService gafasService,
            WompiClient wompiClient) {
        this.pagoRepository = pagoRepository;
        this.gafasService = gafasService;
        this.wompiClient = wompiClient;
    }

    @Override
    public PagoResponseDTO crearPago(PagoRequestDTO request) {

        // Buscar gafas
        Gafas gafas = gafasService.findById(request.getGafasId());

        // Validar stock
        if (gafas.getStock() < request.getCantidad()) {
            throw new BadRequestException("Stock insuficiente");
        }

        // Crear pago
        Pago pago = new Pago();
        pago.setGafas(gafas);
        pago.setCantidad(request.getCantidad());
        pago.setMonto(request.getMonto());
        pago.setMetodoPago(request.getMetodoPago().name());
        pago.setReferencia(request.getReferencia());
        pago.setEstadoPago("PENDIENTE");
        pago.setTransactionId(UUID.randomUUID().toString());
        pago.setFechaCreacion(LocalDateTime.now());

        // Simular integración Wompi
        String referenciaWompi = wompiClient.crearTransaccion(pago);
        pago.setTransactionId(referenciaWompi);

        pagoRepository.save(pago);

        return PagoMapper.toResponseDTO(pago);
    }

    @Override
    public PagoResponseDTO obtenerPago(Long id) {

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));

        return PagoMapper.toResponseDTO(pago);
    }

    @Override
    public List<PagoResponseDTO> listarPagos() {

        return pagoRepository.findAll()
                .stream()
                .map(PagoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PagoResponseDTO> obtenerTodos() {
        return listarPagos();
    }

    @Override
    public PagoResponseDTO obtenerPorId(Long id) {

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id: " + id));

        return PagoMapper.toResponseDTO(pago);
    }

    @Override
    public PagoResponseDTO obtenerPorTransactionId(String transactionId) {

        Pago pago = pagoRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Pago no encontrado con transactionId: " + transactionId
                ));

        return PagoMapper.toResponseDTO(pago);
    }

    @Override
    public void eliminarPago(Long id) {

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id: " + id));

        pagoRepository.delete(pago);
    }


    @Override
    public void procesarWebhook(String transactionId) {

        Pago pago = pagoRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));

        pago.setEstadoPago("APROBADO");

        // Descontar stock usando service
        gafasService.restarStock(
                pago.getGafas().getId(),
                pago.getCantidad()
        );

        pagoRepository.save(pago);
    }
}
