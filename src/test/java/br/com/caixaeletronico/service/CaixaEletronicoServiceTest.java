package br.com.caixaeletronico.service;

import static br.com.caixaeletronico.model.TipoNotaEnum.CEM;
import static br.com.caixaeletronico.model.TipoNotaEnum.CINQUENTA;
import static br.com.caixaeletronico.model.TipoNotaEnum.DEZ;
import static br.com.caixaeletronico.model.TipoNotaEnum.VINTE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.caixaeletronico.infra.GerenciadorNotas;
import br.com.caixaeletronico.model.Nota;
import br.com.caixaeletronico.model.TipoNotaEnum;
import br.com.caixaeletronico.validator.CaixaEletronicoValidator;

public class CaixaEletronicoServiceTest {

	private static final Integer VALOR = 280;
	private static final Integer VALOR_INVALIDO = 580;
	
	private CaixaEletronicoService caixaEletronicoService;
	private CaixaEletronicoValidator validator;
	private GerenciadorNotas gerenciadorNotas;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		validator = mock(CaixaEletronicoValidator.class);
		gerenciadorNotas = mock(GerenciadorNotas.class);
		caixaEletronicoService = new CaixaEletronicoService(validator, gerenciadorNotas);
	}
	
	@Test
	public void deveSacar() {
		doNothing().when(validator).validate(VALOR);
		when(gerenciadorNotas.getNotasDisponiveis()).thenReturn(mockNotasDisponiveis());
		
		List<Nota> notas = caixaEletronicoService.sacar(VALOR);
		List<Nota> esperado = mockUpNotas();
		
		assertEquals(esperado, notas);
		verify(validator).validate(VALOR);
	}
	
	@Test
	public void deveDarErroAoSacar() {
		doNothing().when(validator).validate(VALOR_INVALIDO);
		when(gerenciadorNotas.getNotasDisponiveis()).thenReturn(mockNotasDisponiveis());
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O caixa não possui notas disponíveis para este valor.");
		
		caixaEletronicoService.sacar(VALOR_INVALIDO);
	}
	
	private Map<TipoNotaEnum, Integer> mockNotasDisponiveis() {
		Map<TipoNotaEnum, Integer> notasDisponiveis = new HashMap<>();
		
		notasDisponiveis.put(CEM, 2);
		notasDisponiveis.put(CINQUENTA, 1);
		notasDisponiveis.put(VINTE, 1);
		notasDisponiveis.put(DEZ, 1);
		
		return notasDisponiveis;
	}

	public List<Nota> mockUpNotas() {
		return Arrays.asList(new Nota(CEM),new Nota(CEM),new Nota(CINQUENTA), new Nota(VINTE), new Nota(DEZ));
	}
	
	
}
