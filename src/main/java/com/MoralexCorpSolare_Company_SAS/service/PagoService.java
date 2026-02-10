package com.MoralexCorpSolare_Company_SAS.service;

import com.MoralexCorpSolare_Company_SAS.dto.PagoRequestDTO;
import com.MoralexCorpSolare_Company_SAS.dto.PagoResponseDTO;

import java.util.List;

public interface PagoService {

    PagoResponseDTO crearPago(PagoRequestDTO request);

    PagoResponseDTO obtenerPago(Long id);

    List<PagoResponseDTO> listarPagos();

    void procesarWebhook(String payload);

    List<PagoResponseDTO> obtenerTodos();


    PagoResponseDTO obtenerPorId(Long id);

    PagoResponseDTO obtenerPorTransactionId(String transactionId);

    void eliminarPago(Long id);
}
