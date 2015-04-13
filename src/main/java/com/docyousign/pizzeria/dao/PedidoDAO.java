package com.docyousign.pizzeria.dao;

import java.util.List;

import com.docyousign.pizzeria.model.Pedido;

public interface PedidoDAO {

	public void salvarPedido(Pedido pedido);

	public Pedido getPedido(Integer id);

	public List<Pedido> getPedidos();

}
