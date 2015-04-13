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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@Column(name = "id_produto")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProduto;

	@Column(name = "tipo_produto")
	private Integer tipoProduto;

	@Column(name = "descricao_produto")
	private String descricaoProduto;

	@Column(name = "valor_produto")
	private BigDecimal valorProduto;

	public Integer getIdProduto() {
		return idProduto;
	}

	@OneToMany(targetEntity = SubItensPedido.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_produto")
	private List<SubItensPedido> subItensPedido = new LinkedList<SubItensPedido>();

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(Integer tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}
}
