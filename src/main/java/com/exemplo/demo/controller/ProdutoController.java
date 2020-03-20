package com.exemplo.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exemplo.demo.domain.Produto;
import com.exemplo.demo.service.ProdutoService;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	

	@GetMapping("/cadastrar")
	public String cadastrar(Produto produto) {
		return "/produto/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("produtos", produtoService.buscarTodos());
		return "/produto/listar"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Produto produto, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "/produto/cadastro";
		}
		
		produtoService.salvar(produto);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/produtos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("produto", produtoService.buscarPorId(id));
		return "produto/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Produto produto, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "produto/cadastrar";
		}	
		
		produtoService.editar(produto);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/produtos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir (@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		produtoService.excluir(id);
		attr.addFlashAttribute("success", "Produto excluido com sucesso.");
		return listar(model);
	}
	
}
