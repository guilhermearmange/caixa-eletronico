package br.com.caixaeletronico.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Nota {
	
	private Integer valor;
	
	public Nota(Integer valor) {
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Nota)) {
			return false;
		}
		Nota castOther = (Nota) other;
		return new EqualsBuilder().append(valor, castOther.valor).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(valor).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("valor", valor).toString();
	}
	
}
