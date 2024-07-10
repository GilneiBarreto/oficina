package com.brtec.oficina.service;

import com.brtec.oficina.domain.model.Servico;
import com.brtec.oficina.domain.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }
    public List<Servico> findAllById(List<Long> ids){
        return servicoRepository.findAllById(ids);
    }

    public Optional<Servico> findById(Long id) {
        return servicoRepository.findById(id);
    }

    public Servico create(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void delete(Long id) {
        servicoRepository.deleteById(id);
    }

}
