package br.com.caixaeletronico.validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.caixaeletronico.validator.CaixaEletronicoValidator;

public class CaixaEletronicoValidatorTest {

	private CaixaEletronicoValidator validator;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		validator = new CaixaEletronicoValidator();
	}

	@Test
	public void deveValidarNull() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O valor a ser sacado não pode ser nulo");
		validator.validate(null);
	}
	
	@Test
	public void deveValidarNegativo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O valor a ser sacado não pode ser negativo");
		validator.validate(-1);
	}
	
	@Test
	public void deveValidarValorInvalido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O valor a ser sacado não está disponível. O caixa possui somente notas de 100, 50, 20 e 10 reais");
		validator.validate(1039);
	}
	
	@Test
	public void deveAceitarValoresValidos() {
		validator.validate(380);
	}
}
