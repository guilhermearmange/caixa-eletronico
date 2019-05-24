package br.com.caixaeletronico;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import br.com.caixaeletronico.service.CaixaEletronicoService;

public class CommandLineAppStartupRunnerTest {

	private CommandLineAppStartupRunner commandLineAppStartupRunner;
	private CaixaEletronicoService caixaEletronicoService;

	@Before
	public void setUp() {
		caixaEletronicoService = mock(CaixaEletronicoService.class);
		commandLineAppStartupRunner = new CommandLineAppStartupRunner(caixaEletronicoService);
	}
	
	@Test
	public void naoDeveSacar()  {
		commandLineAppStartupRunner.run(new String[0]);
		verify(caixaEletronicoService, never()).sacar(any());
	}

	@Test
	public void deveSacar()  {
		commandLineAppStartupRunner.run("180");
		verify(caixaEletronicoService).sacar(180);
	}
}
