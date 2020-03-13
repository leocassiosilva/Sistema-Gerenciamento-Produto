package com.exemplo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exemplo.demo.domain.Produto;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@GetMapping("/cadastrar")
	public String cadastrar (Produto produto) {
		return"/produto/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/produto/listar";
	}
	
	

}
