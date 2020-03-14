package com.exemplo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exemplo.demo.domain.Produto;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	
	//Esse atributo vai ser usado quando o sevice for criado
	//private ProdutoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar (Produto produto) {
		return"/produto/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		/*Essa linha abaixo vai precisar da classe service e do metodo buscar todos 
		 * que ainda não foram implementados*/
		//model.addAllAttributes("produtos", service.buscarTodos());
		return "/produto/listar";
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto produto) {
		/*Esse parte do serviço vai ser usada quando for criada 
		 * a parte do service*/
		//service.salvar(produto);
		return "redirect:/produdo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		/*Ainda falta a parte de service*/
		//model.addAllAttributes("produto", service.buscarPorId(id));
		return "produto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Produto produto) {
		//service.editar(produto);
		return "redirect:/produto/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir (@PathVariable("id") Long id, ModelMap model) {
		//service.excluir(id);
		return listar(model);
	}
	
}
