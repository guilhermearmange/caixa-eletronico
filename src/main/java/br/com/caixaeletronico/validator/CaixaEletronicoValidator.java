package br.com.caixaeletronico.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CaixaEletronicoValidator {

	public void validate(Integer valor) {
		Assert.notNull(valor, "O valor a ser sacado não pode ser nulo");

		if(isValorNegativo(valor)) {
			throw new IllegalArgumentException("O valor a ser sacado não pode ser negativo");
		} else if(possuiNotasParaOValor(valor)) {
			throw new IllegalArgumentException("O valor a ser sacado não está disponível. O caixa possui somente notas de 100, 50, 20 e 10 reais");
		}
	}

	private boolean possuiNotasParaOValor(Integer valor) {
		return valor % 10 != 0;
	}

	private boolean isValorNegativo(Integer valor) {
		return valor < 0;
	}
	
}
