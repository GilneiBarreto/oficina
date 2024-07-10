package com.brtec.oficina.controller.dto;

import com.brtec.oficina.domain.model.Veiculo;

public class VeiculoNewDTO {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private Long clienteId;

    VeiculoNewDTO(){}

    public VeiculoNewDTO(String marca, String modelo, int ano, String placa, Long clienteId) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.clienteId = clienteId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
