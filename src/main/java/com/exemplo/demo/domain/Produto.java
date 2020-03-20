package com.exemplo.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUTOS")
public class Produto extends AbstractEntity<Long> {

	@NotBlank(message = "O nome do produto é obrigatorio.")
	@Size(max = 60, message = "O nome deve ter no máximo 60 caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	
    @NotNull
    @Digits(integer = 5, fraction = 0)
    @Column(nullable = false, length = 6)
	private Integer quantidade;

	public String getNome() {
		return nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
