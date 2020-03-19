package com.exemplo.demo.dao;

import org.springframework.stereotype.Repository;

import com.exemplo.demo.domain.Produto;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDao {

}
