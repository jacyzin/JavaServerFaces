package com.docyousign.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subitens_pedido")
public class SubItensPedido {

	@Id
	@Column(name = "id_subitens_pedido")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSubItensPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_itens_pedido")
	private ItensPedido itensPedido;
	
	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produto Produto;

	public Integer getIdSubItensPedido() {
		return idSubItensPedido;
	}

	public void setIdSubItensPedido(Integer idSubItensPedido) {
		this.idSubItensPedido = idSubItensPedido;
	}

	public ItensPedido getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(ItensPedido itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Produto getProduto() {
		return Produto;
	}

	public void setProduto(Produto Produto) {
		this.Produto = Produto;
	}

}
