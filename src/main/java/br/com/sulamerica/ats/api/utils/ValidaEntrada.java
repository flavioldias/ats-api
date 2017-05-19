package br.com.sulamerica.ats.api.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import java.text.ParseException;

public class ValidaEntrada {

	private static final String FORMATO = "dd/MM/yyyy";

	public boolean validaCodigoAts(String codigoDaAts) {
		return !StringUtils.isEmpty(codigoDaAts);		
	}

	public boolean validaCodigoDaGuia(Integer codigoDaGuia) {
		return codigoDaGuia != null;
	}

	public boolean validaNomeDoBeneficiario(String nomeDoBeneficiario) {
		return !StringUtils.isEmpty(nomeDoBeneficiario);	
	}

	public boolean validaDataDePagamento(String dataDePagamento) {
		if (dataDePagamento == null) {
			return false;
		}

		DateFormat dateFormat = new SimpleDateFormat(FORMATO);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(dataDePagamento);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public boolean validaTotalGlosado(Integer totalGlosado){
		return totalGlosado != null;
	}

	public boolean validaTamanhoPDF(Long tamanhoPDF){
		return (tamanhoPDF != null) && (tamanhoPDF != 0);
	}

	public boolean validaArquivoBase64(String arquivoBase64){
		return !StringUtils.isEmpty(arquivoBase64);	
	}
}
	
