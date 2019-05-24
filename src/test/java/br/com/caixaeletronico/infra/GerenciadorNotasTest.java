package br.com.caixaeletronico.infra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.caixaeletronico.model.TipoNotaEnum;
import br.com.caixaeletronico.properties.NotasProperties;

public class GerenciadorNotasTest {

	private static final Integer NOTAS_CEM = 10;
	private static final Integer NOTAS_CINQUENTA = 9;
	private static final Integer NOTAS_VINTE = 8;
	private static final Integer NOTAS_DEZ = 7;
	
	private GerenciadorNotas gerenciadorNotas;
	private NotasProperties notasProperties;
	
	@Before
	public void setUp() {
		notasProperties = mock(NotasProperties.class);
		gerenciadorNotas = new GerenciadorNotas(notasProperties);
	}
	
	@Test
	public void deveRetornarNotas() {
		when(notasProperties.getCem()).thenReturn(NOTAS_CEM);
		when(notasProperties.getCinquenta()).thenReturn(NOTAS_CINQUENTA);
		when(notasProperties.getVinte()).thenReturn(NOTAS_VINTE);
		when(notasProperties.getDez()).thenReturn(NOTAS_DEZ);
		
		Map<TipoNotaEnum, Integer> notasDisponiveis = gerenciadorNotas.getNotasDisponiveis();
		Map<TipoNotaEnum, Integer> expected = mockNotasDisponiveis();
		
		assertEquals(notasDisponiveis, expected);
	}

	private Map<TipoNotaEnum, Integer> mockNotasDisponiveis() {
		Map<TipoNotaEnum, Integer> notasDisponiveis = new HashMap<>();

		notasDisponiveis.put(TipoNotaEnum.CEM, NOTAS_CEM);
		notasDisponiveis.put(TipoNotaEnum.CINQUENTA, NOTAS_CINQUENTA);
		notasDisponiveis.put(TipoNotaEnum.VINTE, NOTAS_VINTE);
		notasDisponiveis.put(TipoNotaEnum.DEZ, NOTAS_DEZ);
		
		return notasDisponiveis;
	}
	
}
