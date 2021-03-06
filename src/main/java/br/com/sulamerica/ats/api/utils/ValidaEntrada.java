package br.com.sulamerica.ats.api.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

import br.com.sulamerica.ats.api.beans.ValidationException;

import java.text.ParseException;

public class ValidaEntrada {

	private static final String FORMATO = "dd/MM/yyyy";

	public boolean validaCodigoAts(String codigoDaAts) {
		if (StringUtils.isEmpty(codigoDaAts) || codigoDaAts == " ") {
			throw new ValidationException("Erro entrada condigo Ats");
		} else {
			return true;
		}
	}

	public boolean validaCodigoDaGuia(Integer codigoDaGuia) {
		if (codigoDaGuia == null) {
			throw new ValidationException("Erro entrada codigo da guia");
		} else {
			return true;
		}
	}

	public boolean validaNomeDoBeneficiario(String nomeDoBeneficiario) {
		if (StringUtils.isEmpty(nomeDoBeneficiario)) {
			throw new ValidationException("Erro entrada nome do beneficiario");
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

	public boolean validaTotalGlosado(Integer totalGlosado) {
		if (totalGlosado == null) {
			throw new ValidationException("Erro entrada total glosado");
		} else {
			return true;
		}
	}

	public boolean validaTamanhoPDF(Long tamanhoPDF) {
		if ((tamanhoPDF == null) || (tamanhoPDF == 0)) {
			throw new ValidationException("Erro entrada tamanho PDF");
		} else {
			return true;
		}
	}

	public boolean validaArquivoBase64(String arquivoBase64) {
		if (StringUtils.isEmpty(arquivoBase64)) {
			throw new ValidationException("Erro entrada arquivo64");
		} else {
			return true;
		}
	}
}
