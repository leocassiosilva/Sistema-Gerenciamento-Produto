package com.exemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.demo.dao.ProdutoDao;
import com.exemplo.demo.domain.Produto;

@Service @Transactional(readOnly = false)
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoDao dao;

	@Override
	public void salvar(Produto produto) {
		dao.save(produto);		
	}

	@Override
	public void editar(Produto produto) {
		dao.update(produto);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Produto buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Produto> buscarTodos() {
		
		return dao.findAll();
	}

	

}
