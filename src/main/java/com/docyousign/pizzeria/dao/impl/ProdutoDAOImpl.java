package com.docyousign.pizzeria.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.docyousign.pizzeria.dao.HibernateUtil;
import com.docyousign.pizzeria.dao.ProdutoDAO;
import com.docyousign.pizzeria.enums.TipoProdutoEnum;
import com.docyousign.pizzeria.model.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {

	private Session session;
	private SessionFactory factory;

	public ProdutoDAOImpl() {
		this.factory = HibernateUtil.getSessionFactory();
		this.session = this.factory.openSession();
	}

	@Override
	public void adicionaProduto(Produto produto) {

		try {
			// Inicia uma transação com o banco de dados.
			Transaction tx = this.session.beginTransaction();
			this.session.save(produto);
			tx.commit();
			System.out.println("salvo com sucesso");
		} finally {
			this.session.close();
		}
	}

	@Override
	public Produto getProduto(Integer id) {
		try {
			return (Produto) this.session.get(Produto.class, id);
		} finally {
			this.session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> getProdutos(TipoProdutoEnum tipoProduto) {
		List<Produto> listaProdutos = new LinkedList<Produto>();
		listaProdutos = this.session.createCriteria(Produto.class)
				.add(Restrictions.eq("tipoProduto", tipoProduto.getCodigoTipoProduto())).list();
		return listaProdutos;
	}

	@Override
	public List<Produto> getProdutos() {
		// TODO Auto-generated method stub
		return null;
	}

}
