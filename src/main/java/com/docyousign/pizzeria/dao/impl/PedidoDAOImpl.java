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
import com.docyousign.pizzeria.model.SubItensPedido;

public class PedidoDAOImpl implements PedidoDAO {

	private Session session;
	private SessionFactory factory;

	public PedidoDAOImpl() {
		this.factory = HibernateUtil.getSessionFactory();
		this.session = this.factory.openSession();
	}

	@Override
	public void salvarPedido(Pedido pedido) {
		try {
			Transaction tx = session.beginTransaction();

			Pedido newPedido = new Pedido();

			// salva o pedido
			Integer id = (Integer) session.save(newPedido);
			pedido.setIdPedido(id);

			List<ItensPedido> itensPedidoList = pedido.getItensPedido();

			for (ItensPedido item : itensPedidoList) {

				ItensPedido newItem = new ItensPedido();
				newItem.setPedido(pedido);
				newItem.setValorItem(item.getValorItem());

				Integer itemId = (Integer) session.save(newItem);
				item.setIdItensPedido(itemId);

				List<SubItensPedido> subItensPedidoList = item
						.getSubItensPedido();

				for (SubItensPedido subItem : subItensPedidoList) {

					subItem.setItensPedido(item);
					session.save(subItem);
				}

			}

			tx.commit();
			System.out
					.println("Pedido salvo com seus respectivos itens + subitens");
		} catch (Throwable t) {
			this.session.getTransaction().rollback();
			t.printStackTrace();
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
