package br.com.caixaeletronico.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import br.com.caixaeletronico.model.Nota;
import br.com.caixaeletronico.validator.CaixaEletronicoValidator;

@Service
public class CaixaEletronicoService {

	private static final List<Integer> NOTAS_DISPONIVEIS = Arrays.asList(100, 50, 20, 10);
	
	private CaixaEletronicoValidator validator;

	public CaixaEletronicoService(CaixaEletronicoValidator validator) {
		this.validator = validator;
	}

	public List<Nota> sacar(Integer valor) {
		validator.validate(valor);

		List<Nota> notas = new ArrayList<Nota>();

		AtomicInteger restante = new AtomicInteger(valor);
		NOTAS_DISPONIVEIS.forEach(nota -> {
			int quantidade = restante.get() / nota;
			restante.set(restante.get() % nota);
			adicionarNotas(notas, quantidade, nota);
		});

		return notas;
	}

	private void adicionarNotas(List<Nota> notas, int quantidade, int nota) {
		IntStream.range(0, quantidade).forEach(index -> {
			notas.add(new Nota(nota));
		});
	}

}
