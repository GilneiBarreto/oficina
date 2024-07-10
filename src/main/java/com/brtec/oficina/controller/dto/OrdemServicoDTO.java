package com.brtec.oficina.controller.dto;

import com.brtec.oficina.domain.model.OrdemServico;
import com.brtec.oficina.domain.model.Servico;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrdemServicoDTO(Long clienteId,
                              Long veiculoId,
                              Long mecanicoId,
                              List<Long> servicoIds,
                              String descricao,
                              LocalDateTime dataAbertura,
                              LocalDateTime dataFechamento,
                              BigDecimal preco,
                              String status
) {

    public OrdemServicoDTO(OrdemServico model) {
        this(
               model.getCliente().getId(),
            model.getVeiculo().getId(),
            model.getMecanico().getId(),
            model.getServicos().stream().map(Servico::getId).toList(),
            model.getDescricao(),
            model.getDataAbertura(),
            model.getDataFechamento(),
            model.getPreco(),
            model.getStatus().name()
        );
    }

}