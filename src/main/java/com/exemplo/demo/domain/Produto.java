package com.exemplo.demo.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUTOS")
public class Produto extends AbstractEntity<Long>{
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;  
	
	@Column(nullable = false)
	private int quantidade;
	
	public String getNome() {
		return nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
