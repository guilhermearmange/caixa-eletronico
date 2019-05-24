package br.com.caixaeletronico.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caixaeletronico.model.Nota;
import br.com.caixaeletronico.service.CaixaEletronicoService;
import br.com.caixaeletronico.validator.CaixaEletronicoValidator;

public class CaixaEletronicoServiceTest {

	private static final Integer VALOR = 280;
	
	private CaixaEletronicoService caixaEletronicoService;
	private CaixaEletronicoValidator validator;
	
	@Before
	public void setUp() {
		validator = mock(CaixaEletronicoValidator.class);
		caixaEletronicoService = new CaixaEletronicoService(validator);
	}
	
	@Test
	public void deveSacar() {
		doNothing().when(validator).validate(VALOR);
		
		List<Nota> notas = caixaEletronicoService.sacar(VALOR);
		List<Nota> esperado = mockUpNotas();
		
		assertEquals(esperado, notas);
		verify(validator).validate(VALOR);
	}
	
	public List<Nota> mockUpNotas() {
		return Arrays.asList(new Nota(100),new Nota(100),new Nota(50), new Nota(20), new Nota(10));
	}
	
	
}
