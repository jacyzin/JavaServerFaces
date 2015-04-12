package com.docyousign.pizzeria.dao;

import java.util.List;

import com.docyousign.pizzeria.model.ItensPedido;
import com.docyousign.pizzeria.model.Pedido;
import com.docyousign.pizzeria.model.SubItensPedido;

public interface PedidoDAO {

	public void salvarPedido(Pedido pedido, List<ItensPedido> itensPedidoList,
			List<SubItensPedido> subItensPedidoList);

	public Pedido getPedido(Integer id);

	public List<Pedido> getPedidos();

}
