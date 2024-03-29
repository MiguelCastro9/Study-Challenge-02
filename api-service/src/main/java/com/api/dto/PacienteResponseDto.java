package com.api.dto;

import com.api.model.ContatoModel;
import com.api.model.EnderecoModel;
import com.api.model.FisicoModel;
import com.api.model.PacienteModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "paciente Response DTO")
public class PacienteResponseDto {

    private Long id;
    private String nome;
    private String cpf;
    private Date data_nascimento;
    private String genero;
    private List<EnderecoModel> endereco;
    private List<ContatoModel> contato;
    private FisicoModel fisico;

    public PacienteResponseDto(Long id, String nome, String cpf, Date data_nascimento, String genero, List<EnderecoModel> endereco, List<ContatoModel> contato, FisicoModel fisico) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.contato = contato;
        this.fisico = fisico;
    }

    public static PacienteResponseDto converterEntidadeParaPacienteDto(PacienteModel pacienteModel) {
        return new PacienteResponseDto(pacienteModel.getId(), pacienteModel.getNome(), pacienteModel.getCpf(),
                pacienteModel.getData_nascimento(), pacienteModel.getGenero().name(), pacienteModel.getEndereco(), pacienteModel.getContato(),
                pacienteModel.getFisico());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public List<EnderecoModel> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoModel> endereco) {
        this.endereco = endereco;
    }

    public List<ContatoModel> getContato() {
        return contato;
    }

    public void setContato(List<ContatoModel> contato) {
        this.contato = contato;
    }

    public FisicoModel getFisico() {
        return fisico;
    }

    public void setFisico(FisicoModel fisico) {
        this.fisico = fisico;
    }
}
