package com.docyousign.pizzeria.faces.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.docyousign.pizzeria.enums.TipoProdutoEnum;
import com.docyousign.pizzeria.model.ItensPedido;
import com.docyousign.pizzeria.model.Pedido;
import com.docyousign.pizzeria.model.Produto;
import com.docyousign.pizzeria.model.SubItensPedido;
import com.docyousign.pizzeria.service.PedidoService;
import com.docyousign.pizzeria.service.impl.PedidoServiceImpl;

@ManagedBean(name = "pedidoBean")
@SessionScoped
public class PedidoBean implements Serializable {

	private static final long serialVersionUID = 1971796268250083683L;

	private Integer idProduto = new Integer(0);
	private Integer tipoProduto = new Integer(1);
	private List<Produto> pizza = new ArrayList<Produto>();
	private List<ItensPedido> pedidoList = new ArrayList<ItensPedido>();

	public List<Produto> getProdutos() {
		// retorna lista de produtos do banco
		PedidoService pedidoService = new PedidoServiceImpl();
		return pedidoService.getProdutos(TipoProdutoEnum.getById(tipoProduto));
	}

	public void addProduto() {

		TipoProdutoEnum tipo = TipoProdutoEnum.getById(tipoProduto);

		switch (tipo) {

		case PIZZA:
			updatePizza(idProduto);
			break;
		case BEBIDA:
			updatePedido(idProduto);
			break;
		case SOBREMESA:
			updatePedido(idProduto);
			break;
		default:
			break;
		}

	}

	private void updatePedido(Integer idProduto) {

		Produto p = new PedidoServiceImpl().getProduto(idProduto);

		ItensPedido newItem = new ItensPedido();
		newItem.setValorItem(p.getValorProduto());

		SubItensPedido newSubItem = new SubItensPedido();
		newSubItem.setProduto(p);

		List<SubItensPedido> subItensList = new ArrayList<SubItensPedido>();
		subItensList.add(newSubItem);

		newItem.setSubItensPedido(subItensList);
		pedidoList.add(newItem);

	}

	private void updatePizza(Integer produtoId) {
		// monta os 4 sabores da pizza
		Produto p = new PedidoServiceImpl().getProduto(idProduto);
		pizza.add(p);

		int tamanhoPizza = pizza.size();

		if (tamanhoPizza == 4) {

			ItensPedido newItem = new ItensPedido();
			BigDecimal valorPizza = calculaValorPizza();
			newItem.setValorItem(valorPizza);

			List<SubItensPedido> subItensList = new ArrayList<SubItensPedido>();

			for (Produto pedacoPizza : pizza) {
				SubItensPedido newSubItem = new SubItensPedido();
				newSubItem.setProduto(pedacoPizza);
				subItensList.add(newSubItem);
			}

			newItem.setSubItensPedido(subItensList);
			pedidoList.add(newItem);
			pizza.clear();
		}

	}

	public BigDecimal calculaValorPizza() {
		// calcula maior valor dos pedacos
		BigDecimal maiorValor = new BigDecimal(0);

		for (Produto pedacoPizza : pizza) {
			if (pedacoPizza.getValorProduto().compareTo(maiorValor) == 1) {
				maiorValor = pedacoPizza.getValorProduto();
			}
		}
		return maiorValor;
	}

	public BigDecimal getTotalPedido() {
		// calcula valor total do pedido
		BigDecimal totalPedido = new BigDecimal(0);

		for (ItensPedido itens : pedidoList) {
			totalPedido = totalPedido.add(itens.getValorItem());
		}

		return totalPedido;
	}

	public void finalizarPedido() {
		// minta lista para salvar pedido
		Pedido pedido = new Pedido();
		pedido.setItensPedido(pedidoList);

		PedidoService pedidoService = new PedidoServiceImpl();
		pedidoService.salvarPedido(pedido);
		reset();
	}

	private void reset() {
		// limpa pedido
		idProduto = new Integer(0);
		tipoProduto = new Integer(1);
		pizza = new ArrayList<Produto>();
		pedidoList = new ArrayList<ItensPedido>();
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(Integer tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<ItensPedido> getPedidoList() {
		return pedidoList;
	}

	public void setPedidoList(List<ItensPedido> pedidoList) {
		this.pedidoList = pedidoList;
	}

	public List<Produto> getPizza() {
		return pizza;
	}

	public void setPizza(List<Produto> pizza) {
		this.pizza = pizza;
	}
}