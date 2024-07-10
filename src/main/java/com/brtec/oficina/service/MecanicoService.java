package com.brtec.oficina.service;

import com.brtec.oficina.domain.model.Mecanico;
import com.brtec.oficina.domain.repository.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MecanicoService {
    @Autowired
    private final MecanicoRepository mecanicoRepository;


    public MecanicoService(MecanicoRepository mecanicoRepository) {
        this.mecanicoRepository = mecanicoRepository;
    }

    public List<Mecanico> findAll(){
        return mecanicoRepository.findAll();
    }

    public Optional<Mecanico> findById(Long id){
        return mecanicoRepository.findById(id);
    }
}
