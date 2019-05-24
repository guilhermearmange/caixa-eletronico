package br.com.caixaeletronico;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.caixaeletronico.service.CaixaEletronicoService;


@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	private CaixaEletronicoService service;
	
    public CommandLineAppStartupRunner(CaixaEletronicoService service) {
		this.service = service;
	}
    
    @Override
    public void run(String...args) {
    	if(args.length != 0) {
    		System.out.println("===============================================");
    		Arrays.stream(args).map(valor -> new Integer(valor)).forEach(this::sacar);
    		System.out.println("===============================================");
    	}
    }
    
    private void sacar(Integer valor) {
    	System.out.println("\nSacando o valor de: " + valor);
    	try {
    		List<Integer> notas = service.sacar(valor).stream().map(nota -> nota.getTipo().getValor()).collect(toList());
			System.out.println("Notas: " + notas);
    	} catch (Exception e) {
			System.out.println("Não foi possivel concluir o saque devido ao motivo: " + e.getMessage());
		}
    }
}