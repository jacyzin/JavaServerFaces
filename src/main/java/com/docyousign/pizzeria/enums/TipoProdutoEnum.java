package com.docyousign.pizzeria.enums;

public enum TipoProdutoEnum {

	PIZZA(1),
	BEBIDA(2),
	SOBREMESA(3);
	
	
	private int codigoTipoProduto;
	
	TipoProdutoEnum(Integer codigoTipoProduto) {
		this.codigoTipoProduto = codigoTipoProduto;
	}

	public Integer getCodigoTipoProduto() {
		return codigoTipoProduto;
	}

	public void setCodigoTipoProduto(Integer codigoTipoProduto) {
		this.codigoTipoProduto = codigoTipoProduto;
	}
	
	public static TipoProdutoEnum getById(Integer id) {
	    for(TipoProdutoEnum tipo : values()) {
	        if(tipo.codigoTipoProduto == id) return tipo;
	    }
	    return null;
	 }
	
}
