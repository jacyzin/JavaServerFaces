package com.docyousign.pizzeria.service.impl;

import java.util.List;

import com.docyousign.pizzeria.dao.PedidoDAO;
import com.docyousign.pizzeria.dao.ProdutoDAO;
import com.docyousign.pizzeria.dao.impl.PedidoDAOImpl;
import com.docyousign.pizzeria.dao.impl.ProdutoDAOImpl;
import com.docyousign.pizzeria.enums.TipoProdutoEnum;
import com.docyousign.pizzeria.model.Pedido;
import com.docyousign.pizzeria.model.Produto;
import com.docyousign.pizzeria.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

	private PedidoDAO pedidoDAO;
	private ProdutoDAO produtoDAO;

	public PedidoServiceImpl() {
		this.produtoDAO = new ProdutoDAOImpl();
		this.pedidoDAO = new PedidoDAOImpl();
	}

	public List<Produto> getProdutos(TipoProdutoEnum tipoProduto) {
		return produtoDAO.getProdutos(tipoProduto);
	}

	public Produto getProduto(Integer idProduto) {
		return produtoDAO.getProduto(idProduto);
	}

	public void salvarPedido(Pedido pedido) {
		this.pedidoDAO.salvarPedido(pedido);
	}

}
