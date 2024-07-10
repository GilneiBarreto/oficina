package com.brtec.oficina.controller;

import com.brtec.oficina.controller.dto.VeiculoNewDTO;
import com.brtec.oficina.domain.model.Cliente;
import com.brtec.oficina.domain.model.Veiculo;
import com.brtec.oficina.service.ClienteService;
import com.brtec.oficina.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;
    private final ClienteService clienteService;
    public VeiculoController(VeiculoService veiculoService, ClienteService clienteService) {
        this.veiculoService = veiculoService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll(){
        List<Veiculo> veiculos = veiculoService.findAll();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> fidById(@PathVariable Long id){
        Veiculo veiculo = veiculoService.findById(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Veiculo> create(@RequestBody VeiculoNewDTO dto){
        Cliente cliente = this.clienteService.findById(dto.getClienteId());
        Veiculo veiculo = new Veiculo(null, dto.getMarca(), dto.getModelo(), dto.getAno(), dto.getPlaca(), cliente);

        Veiculo created = veiculoService.create(veiculo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}
