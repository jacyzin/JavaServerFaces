package com.docyousign.pizzeria.service;

import java.util.List;

import com.docyousign.pizzeria.enums.TipoProdutoEnum;
import com.docyousign.pizzeria.model.Pedido;
import com.docyousign.pizzeria.model.Produto;

public interface PedidoService {

	public List<Produto> getProdutos(TipoProdutoEnum tipoProduto);
	public Produto getProduto(Integer idProduto);
	public void salvarPedido(Pedido pedido);

}
