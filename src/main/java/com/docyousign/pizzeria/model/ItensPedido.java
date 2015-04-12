package com.docyousign.pizzeria.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {

	@Id
	@Column(name = "id_itens_pedido")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idItensPedido;

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@Column(name = "valor_item")
	private BigDecimal valorItem;

	@OneToMany(targetEntity = SubItensPedido.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_subitens_pedido")
	private List<SubItensPedido> subItensPedido = new LinkedList<SubItensPedido>();

	public List<SubItensPedido> getSubItensPedido() {
		return subItensPedido;
	}

	public void setSubItensPedido(List<SubItensPedido> subItensPedido) {
		this.subItensPedido = subItensPedido;
	}

	public Integer getIdItensPedido() {
		return idItensPedido;
	}

	public void setIdItensPedido(Integer idItensPedido) {
		this.idItensPedido = idItensPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getValorItem() {
		return valorItem;
	}

	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}
}
