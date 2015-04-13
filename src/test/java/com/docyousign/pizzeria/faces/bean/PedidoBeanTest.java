package com.docyousign.pizzeria.faces.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.docyousign.pizzeria.model.ItensPedido;
import com.docyousign.pizzeria.model.Produto;

import static org.junit.Assert.assertEquals;

public class PedidoBeanTest{
	
	private static PedidoBean pedidoBean;
	
	@BeforeClass
	public static void initTest() {
		pedidoBean = new PedidoBean();
	}


	@Test
	public void testCalculaMaiorValorPizzaCompleta() {
		
		BigDecimal menorValor = new BigDecimal("17");
		BigDecimal maiorValor = new BigDecimal("20");
		
		List<Produto> pedacosPizza = new ArrayList<Produto>();
		
		Produto pedaco1 = new Produto();
		Produto pedaco2 = new Produto();
		Produto pedaco3 = new Produto();
		Produto pedaco4 = new Produto();
		
		pedaco1.setValorProduto(menorValor);
		pedaco2.setValorProduto(maiorValor);
		pedaco3.setValorProduto(menorValor);
		pedaco4.setValorProduto(menorValor);
		
		pedacosPizza.add(pedaco1);
		pedacosPizza.add(pedaco2);
		pedacosPizza.add(pedaco3);
		pedacosPizza.add(pedaco4);
		
		pedidoBean.setPizza(pedacosPizza);
			
		assertEquals(pedidoBean.calculaValorPizza(), maiorValor);
	}
	
	@Test
	public void testSomaValorTotalPedido() {
		
		List<ItensPedido> pedidoList = new ArrayList<ItensPedido>();
		
		ItensPedido item1 = new ItensPedido();
		item1.setValorItem(new BigDecimal("12"));
		
		ItensPedido item2 = new ItensPedido();
		item2.setValorItem(new BigDecimal("14"));
		
		ItensPedido item3 = new ItensPedido();
		item3.setValorItem(new BigDecimal("17"));
		
		pedidoList.add(item1);
		pedidoList.add(item2);
		pedidoList.add(item3);
		
		BigDecimal total = item1.getValorItem().add(item2.getValorItem()).add(item3.getValorItem());
		
		pedidoBean.setPedidoList(pedidoList);
			
		assertEquals(pedidoBean.getTotalPedido(), total);
	}



}