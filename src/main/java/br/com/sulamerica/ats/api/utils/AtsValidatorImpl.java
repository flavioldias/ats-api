package br.com.sulamerica.ats.api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.sulamerica.ats.api.beans.ValidationException;

@Component
public class AtsValidatorImpl implements AtsValidator {

	private static final String FORMATO = "dd/MM/yyyy";

	@Override
	public void validaCodigoAts(String codigoDaAts) {
		if (StringUtils.isBlank(codigoDaAts)) {
			throw new ValidationException("Erro entrada condigo Ats");
		}
	}
	
	@Override
	public void validaCodigoDaGuia(Integer codigoDaGuia) {
		if (codigoDaGuia == null || codigoDaGuia.equals(0)) {
			throw new ValidationException("Erro entrada codigo da guia");
		}
	}
	
	@Override
	public void validaNomeDoBeneficiario(String nomeDoBeneficiario) {
		if (StringUtils.isBlank(nomeDoBeneficiario)) {
			throw new ValidationException("Erro entrada nome do beneficiario");
		}
	}

	@Override
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

	@Override
	public void validaTotalGlosado(Integer totalGlosado) {
		if (totalGlosado == null || totalGlosado.equals(0)) {
			throw new ValidationException("Erro entrada total glosado");
		}
	}

	@Override
	public void validaTamanhoPDF(Long tamanhoPDF) {
		if ((tamanhoPDF == null) || (tamanhoPDF == 0)) {
			throw new ValidationException("Erro entrada tamanho PDF");
		}
	}

	@Override
	public void validaArquivoBase64(String arquivoBase64) {
		if (StringUtils.isBlank(arquivoBase64)) {
			throw new ValidationException("Erro entrada arquivo64");
		}
	}
}
