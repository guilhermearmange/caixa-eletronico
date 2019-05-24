package br.com.caixaeletronico.infra;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.caixaeletronico.model.TipoNotaEnum;
import br.com.caixaeletronico.properties.NotasProperties;

@Component
public class GerenciadorNotas {
	
	private NotasProperties notasProperties;
	private HashMap<TipoNotaEnum, Integer> notas;
	
	public GerenciadorNotas(NotasProperties notasProperties) {
		this.notasProperties = notasProperties; 
	}
	
    public Map<TipoNotaEnum, Integer> getNotasDisponiveis(){
    	if (notas == null) {
    		notas = new HashMap<>();
    		notas.put(TipoNotaEnum.CEM, notasProperties.getCem());
    		notas.put(TipoNotaEnum.CINQUENTA, notasProperties.getCinquenta());
    		notas.put(TipoNotaEnum.VINTE, notasProperties.getVinte());
    		notas.put(TipoNotaEnum.DEZ, notasProperties.getDez());
    	}
		return notas;
    }
	
}
