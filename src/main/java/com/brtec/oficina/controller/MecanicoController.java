package com.brtec.oficina.controller;

import com.brtec.oficina.domain.model.Mecanico;
import com.brtec.oficina.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mecanicos")
public class MecanicoController {

    @Autowired
    private final MecanicoService mecanicoService;

    public MecanicoController(MecanicoService mecanicoService) {
        this.mecanicoService = mecanicoService;
    }

    @GetMapping
    public ResponseEntity<List<Mecanico>> findAll(){
        List<Mecanico> mecanicos = mecanicoService.findAll();
        return ResponseEntity.ok(mecanicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mecanico> findById(@PathVariable Long id){
        var mecanico = mecanicoService.findById(id).get();
        return ResponseEntity.ok(mecanico);
    }
    @PostMapping
    public ResponseEntity<Mecanico> create(@RequestBody Mecanico mecanico){
        mecanicoService.create(mecanico);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mecanico.getId())
                .toUri();
        return ResponseEntity.created(location).body(mecanico);
    }
}
