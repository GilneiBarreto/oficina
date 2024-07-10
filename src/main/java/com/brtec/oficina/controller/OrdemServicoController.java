package com.brtec.oficina.controller;

import com.brtec.oficina.controller.dto.OrdemServicoDTO;
import com.brtec.oficina.domain.model.OrdemServico;
import com.brtec.oficina.service.OrdemServicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {
    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping
    public List<OrdemServico> findAll() {
        return ordemServicoService.findAll();
    }

    @PostMapping
    public ResponseEntity<OrdemServico> create(@RequestBody OrdemServicoDTO ordemServicoDTO) {
        var ordemServico = ordemServicoService.toModel(ordemServicoDTO);
        System.out.println(ordemServicoDTO);
        ordemServico = ordemServicoService.create(ordemServico);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ordemServico.getId())
                .toUri();
        return ResponseEntity.created(location).body(ordemServico);
    }


}
