package br.com.caixaeletronico.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import br.com.caixaeletronico.infra.GerenciadorNotas;
import br.com.caixaeletronico.model.Nota;
import br.com.caixaeletronico.model.TipoNotaEnum;
import br.com.caixaeletronico.validator.CaixaEletronicoValidator;

@Service
public class CaixaEletronicoService {

	private CaixaEletronicoValidator validator;
	private GerenciadorNotas gerenciadorNotas;

	public CaixaEletronicoService(CaixaEletronicoValidator validator, GerenciadorNotas gerenciadorNotas) {
		this.validator = validator;
		this.gerenciadorNotas = gerenciadorNotas;
	}

	public List<Nota> sacar(Integer valor) {
		validator.validate(valor);

		List<Nota> notas = new ArrayList<Nota>();
		Map<TipoNotaEnum, Integer> notasDisponiveis = gerenciadorNotas.getNotasDisponiveis();

		AtomicInteger restante = new AtomicInteger(valor);
		Arrays.stream(TipoNotaEnum.values()).forEach(tipoNota -> {
			int valorNota = tipoNota.getValor();
			int valorASacar = restante.get();
			int quantidadeNecessaria = valorASacar / valorNota;
			int quantidade = Math.min(quantidadeNecessaria, notasDisponiveis.get(tipoNota));
			restante.set(valorASacar - (quantidade * valorNota));
			adicionarNotas(notas, quantidade, tipoNota);
		});
		
		if(restante.get() == 0) {
			decrementarNotas(notas, notasDisponiveis);
			return notas;
		} else {
			throw new IllegalArgumentException("O caixa não possui notas disponíveis para este valor.");
		}
	}

	private void decrementarNotas(List<Nota> notas, Map<TipoNotaEnum, Integer> notasDisponiveis) {
		notas.forEach(nota -> {
			TipoNotaEnum tipo = nota.getTipo();
			notasDisponiveis.put(tipo, notasDisponiveis.get(tipo) - 1);
		});
	}

	private void adicionarNotas(List<Nota> notas, int quantidade, TipoNotaEnum tipo) {
		IntStream.range(0, quantidade).forEach(index -> {
			notas.add(new Nota(tipo));
		});
	}

}
