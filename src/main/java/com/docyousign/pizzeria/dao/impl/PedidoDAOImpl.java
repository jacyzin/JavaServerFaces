package com.docyousign.pizzeria.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.docyousign.pizzeria.dao.HibernateUtil;
import com.docyousign.pizzeria.dao.PedidoDAO;
import com.docyousign.pizzeria.model.ItensPedido;
import com.docyousign.pizzeria.model.Pedido;
import com.docyousign.pizzeria.model.Produto;
import com.docyousign.pizzeria.model.SubItensPedido;

public class PedidoDAOImpl implements PedidoDAO {

	private Session session;
	private SessionFactory factory;

	public PedidoDAOImpl() {
		this.factory = HibernateUtil.getSessionFactory();
		this.session = this.factory.openSession();
	}

	@Override
	public void salvarPedido(Produto produto, Pedido pedido, ItensPedido itensPedido, SubItensPedido subItensPedido) {
		try {
			// Inicia uma transação com o banco de dados.
			Transaction tx = this.session.beginTransaction();
			itensPedido.setPedido(pedido);
			subItensPedido.setItensPedido(itensPedido);
			subItensPedido.setProduto(produto);
			//this.session.save(produto);
			this.session.save(pedido);
			this.session.save(itensPedido);
			this.session.save(subItensPedido);
			tx.commit();
			System.out.println("salvo com sucesso");
		} finally {
			this.session.close();
		}
	}

	@Override
	public Pedido getPedido(Integer id) {
		try {
			return (Pedido) this.session.get(Pedido.class, id);
		} finally {
			this.session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> getPedidos() {
		try {
			List<Pedido> listaPedidos = new LinkedList<Pedido>();
			listaPedidos = this.session.createCriteria(Pedido.class).list();
			return listaPedidos;
		} finally {
			this.session.close();
		}
	}

}
