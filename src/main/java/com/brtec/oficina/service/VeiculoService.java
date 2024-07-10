package com.brtec.oficina.service;

import com.brtec.oficina.domain.model.Cliente;
import com.brtec.oficina.domain.model.Veiculo;
import com.brtec.oficina.domain.repository.ClienteRepository;
import com.brtec.oficina.domain.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }

    public Veiculo create(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public Veiculo findById(Long id){
        return veiculoRepository.findById(id).orElseThrow(()-> new RuntimeException("Veículo não encontrado com ID: " + id));
    }
}
