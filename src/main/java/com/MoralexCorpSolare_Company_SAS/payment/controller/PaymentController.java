package com.MoralexCorpSolare_Company_SAS.controller;

import com.MoralexCorpSolare_Company_SAS.dto.PagoRequestDTO;
import com.MoralexCorpSolare_Company_SAS.dto.PagoResponseDTO;
import com.MoralexCorpSolare_Company_SAS.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PaymentController {

    private final PagoService pagoService;

    public PaymentController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    // Crear pago
    @PostMapping
    public ResponseEntity<PagoResponseDTO> crearPago(@RequestBody PagoRequestDTO request) {

        PagoResponseDTO response = pagoService.crearPago(request);
        return ResponseEntity.ok(response);
    }

    // Consultar pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<PagoResponseDTO> obtenerPago(@PathVariable Long id) {

        PagoResponseDTO response = pagoService.obtenerPago(id);
        return ResponseEntity.ok(response);
    }

    // Listar pagos
    @GetMapping
    public ResponseEntity<?> listarPagos() {
        return ResponseEntity.ok(pagoService.listarPagos());
    }
}
