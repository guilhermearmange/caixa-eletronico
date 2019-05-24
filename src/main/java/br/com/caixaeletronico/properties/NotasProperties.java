package br.com.caixaeletronico.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotasProperties {

	@Value("${notas.cem:10}")
    private Integer cem;
	
	@Value("${notas.cinquenta:10}")
    private Integer cinquenta;
	
	@Value("${notas.vinte:10}")
    private Integer vinte;
	
	@Value("${notas.dez:10}")
    private Integer dez;

	public Integer getCem() {
		return cem;
	}

	public void setCem(Integer cem) {
		this.cem = cem;
	}

	public Integer getCinquenta() {
		return cinquenta;
	}

	public void setCinquenta(Integer cinquenta) {
		this.cinquenta = cinquenta;
	}

	public Integer getVinte() {
		return vinte;
	}

	public void setVinte(Integer vinte) {
		this.vinte = vinte;
	}

	public Integer getDez() {
		return dez;
	}

	public void setDez(Integer dez) {
		this.dez = dez;
	}

}
