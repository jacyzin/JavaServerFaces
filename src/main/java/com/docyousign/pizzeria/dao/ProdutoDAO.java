package com.docyousign.pizzeria.dao;

import java.util.List;

import com.docyousign.pizzeria.enums.TipoProdutoEnum;
import com.docyousign.pizzeria.model.Produto;

public interface ProdutoDAO {

	public void adicionaProduto(Produto produto);
	public Produto getProduto(Integer id);
	public List<Produto> getProdutos();
	public List<Produto> getProdutos(TipoProdutoEnum tipoProduto);
	
}
