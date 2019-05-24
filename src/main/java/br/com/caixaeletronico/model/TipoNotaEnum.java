package br.com.caixaeletronico.model;

public enum TipoNotaEnum {
	CEM(100), CINQUENTA(50), VINTE(20), DEZ(10);

	private Integer valor;

	private TipoNotaEnum(Integer valor) {
		this.setValor(valor);
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
