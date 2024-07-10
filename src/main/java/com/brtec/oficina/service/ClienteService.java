package com.brtec.oficina.service;

import com.brtec.oficina.domain.model.Cliente;
import com.brtec.oficina.domain.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    ClienteService(ClienteRepository cleinteRepository){
        this.clienteRepository = cleinteRepository;
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente create(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado com ID: " + id));
    }
}
