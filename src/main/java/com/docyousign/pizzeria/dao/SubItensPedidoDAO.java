package com.docyousign.pizzeria.dao;

import java.util.List;

import com.docyousign.pizzeria.model.SubItensPedido;

public interface SubItensPedidoDAO {

	public void adicionaSubItensPedido(SubItensPedido subItensPedido);
	public void atualizaSubItensPedido(SubItensPedido subItensPedido);
	public SubItensPedido getSubItensPedido(int id);
	public List<SubItensPedido> getSubItensPedido();
	
}
