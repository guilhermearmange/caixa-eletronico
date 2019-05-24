package br.com.caixaeletronico.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Nota {

	private TipoNotaEnum tipo;

	public Nota(TipoNotaEnum tipo) {
		this.tipo = tipo;
	}

	public TipoNotaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoNotaEnum tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Nota)) {
			return false;
		}
		Nota castOther = (Nota) other;
		return new EqualsBuilder().append(tipo, castOther.tipo).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(tipo).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("tipo", tipo).toString();
	}

}
