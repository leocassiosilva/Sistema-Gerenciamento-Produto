package com.exemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exemplo.demo.domain.Produto;
import com.exemplo.demo.service.ProdutoService;

import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	
	//Esse atributo vai ser usado quando o sevice for criado
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar (Produto produto) {
		return"/produto/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("produtos", produtoService.buscarTodos());
		return "/produto/listar";
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto produto, RedirectAttributes attr) {
		produtoService.salvar(produto);
		attr.addFlashAttribute("success", "Produto inserido com sucesso.");
		return "redirect:/produdo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("produto", produtoService.buscarPorId(id));
		return "produto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Produto produto, RedirectAttributes attr) {
		produtoService.editar(produto);
		attr.addFlashAttribute("success", "Produto atualizado com sucesso.");
		return "redirect:/produto/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir (@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		produtoService.excluir(id);
		attr.addFlashAttribute("success", "Produto excluido com sucesso.");
		return listar(model);
	}
	
}
