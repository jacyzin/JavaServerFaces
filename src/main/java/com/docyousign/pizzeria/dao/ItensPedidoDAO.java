package com.docyousign.pizzeria.dao;

import java.util.List;

import com.docyousign.pizzeria.model.ItensPedido;

public interface ItensPedidoDAO {

	public void adicionaItensPedido(ItensPedido itensPedido);
	public void atualizaItensPedido(ItensPedido itensPedido);
	public ItensPedido getItensPedido(int id);
	public List<ItensPedido> getItensPedidos();
	
}
