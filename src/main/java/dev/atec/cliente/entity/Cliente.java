package dev.atec.cliente.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeBase{

    private String nome;
    private String documento;
    private String email;
    private String telefone;
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Cliente() {
    }

    public Cliente(String nome, String documento, String email, String telefone) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente(Long id, String nome, String documento, String email, String telefone) {
        super(id);
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.telefone = telefone;
    }

    public void registarDataCadastro() {
        this.dataCadastro= LocalDateTime.now();
    }

    public void registrarDataAtualizacao() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
