package com.MoralexCorpSolare_Company_SAS.controller;


import com.MoralexCorpSolare_Company_SAS.entity.Gafas;
import com.MoralexCorpSolare_Company_SAS.service.GafasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gafas")
public class GafasController {

    private final GafasService gafasService;

    public GafasController(GafasService gafasService) {
        this.gafasService = gafasService;
    }

    @PostMapping
    public ResponseEntity<Gafas> crear(@RequestBody Gafas gafas){
        Gafas crear= gafasService.save(gafas);
        return new ResponseEntity<>(crear, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Gafas>> getAll(){
        return ResponseEntity.ok(gafasService.findAll());
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<Gafas>> GetMarca(@PathVariable String marca){
        return ResponseEntity.ok(gafasService.findMarca(marca));
    }

    @GetMapping("/disponible")
    public ResponseEntity<List<Gafas>> getAvailable(){
        return ResponseEntity.ok(gafasService.findAvailable());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gafas> getById(@PathVariable Long id){
        return ResponseEntity.ok(gafasService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        gafasService.eliminar(id);
    }
}
