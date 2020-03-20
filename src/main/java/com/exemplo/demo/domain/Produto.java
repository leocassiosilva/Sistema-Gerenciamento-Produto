package com.exemplo.demo.domain;

import javax.persistence.*;
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
	
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull(message = "Quantidade é obrigatoria.")
	private long quantidade;

	public String getNome() {
		return nome;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
}
