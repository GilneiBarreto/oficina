package com.brtec.oficina.service;

import com.brtec.oficina.controller.dto.OrdemServicoDTO;
import com.brtec.oficina.domain.model.*;
import com.brtec.oficina.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final ClienteService clienteService;
    private final VeiculoService veiculoService;
    private final ServicoService servicoService;
    private final MecanicoService mecanicoService;

    @Autowired
    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository, ClienteService clienteService, VeiculoService veiculoService, ServicoService servicoService, MecanicoService mecanicoService) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
        this.servicoService = servicoService;
        this.mecanicoService = mecanicoService;
    }

    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    public Optional<OrdemServico> findById(Long id) {
        return ordemServicoRepository.findById(id);
    }

    public OrdemServico create(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    public void delete(Long id) {
        ordemServicoRepository.deleteById(id);
    }

    public OrdemServico toModel(OrdemServicoDTO dto) {
        OrdemServico model = new OrdemServico();
        Cliente cliente = clienteService.findById(dto.clienteId());
        Veiculo veiculo = veiculoService.findById(dto.veiculoId());
        List<Servico> servicos = servicoService.findAllById(dto.servicoIds());
        Mecanico mecanico = mecanicoService.findById(dto.mecanicoId()).get();
        model.setCliente(cliente);
        model.setMecanico(mecanico);
        model.setVeiculo(veiculo);
        model.setServicos(servicos);
        model.setDescricao(dto.descricao());
        model.setDataAbertura(dto.dataAbertura());
        model.setDataFechamento(dto.dataFechamento());
        model.setPreco(dto.preco());
        model.setStatus(StatusOrdemServico.valueOf(dto.status()));
        return model;
    }
}
