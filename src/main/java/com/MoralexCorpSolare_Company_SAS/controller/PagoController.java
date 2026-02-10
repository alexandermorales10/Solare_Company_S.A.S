package com.MoralexCorpSolare_Company_SAS.controller;

import com.MoralexCorpSolare_Company_SAS.dto.PagoRequestDTO;
import com.MoralexCorpSolare_Company_SAS.dto.PagoResponseDTO;
import com.MoralexCorpSolare_Company_SAS.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    // ✅ Crear pago
    @PostMapping
    public ResponseEntity<PagoResponseDTO> crearPago(
            @RequestBody PagoRequestDTO requestDTO) {

        return ResponseEntity.ok(pagoService.crearPago(requestDTO));
    }

    // ✅ Obtener todos los pagos
    @GetMapping
    public ResponseEntity<List<PagoResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(pagoService.obtenerTodos());
    }

    // ✅ Obtener pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<PagoResponseDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(pagoService.obtenerPorId(id));
    }

    // ✅ Buscar pago por transactionId
    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<PagoResponseDTO> obtenerPorTransactionId(
            @PathVariable String transactionId) {

        return ResponseEntity.ok(
                pagoService.obtenerPorTransactionId(transactionId)
        );
    }

    // ✅ Eliminar pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {

        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }
}
