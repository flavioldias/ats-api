package br.com.sulamerica.ats.api.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ValidaEntrada {

	private static final String FORMATO = "dd/MM/yyyy";

	public boolean validaCodigoAts(String codigoDaAts) {
		if ((codigoDaAts == null) || (codigoDaAts.equals(" "))) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validaCodigoDaGuia(int codigoDaGuia) {
		if (codigoDaGuia == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validaNomeDoBeneficiario(String nomeDoBeneficiario) {
		if ((nomeDoBeneficiario == null) || (nomeDoBeneficiario.equals(" "))) {
			return false;
		} else {
			return true;
		}
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

	public boolean validaTotalGlosado(int totalGlosado){
		if (totalGlosado <= 0) {
			return false;
		} else {
			return true;
		}		
	}

	public boolean validaTamanhoPDF(int tamanhoPDF){
		if (tamanhoPDF <= 0) {
			return false;
		} else {
			return true;
		}		
	}
}
