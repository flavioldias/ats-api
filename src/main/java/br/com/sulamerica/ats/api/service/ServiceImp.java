package br.com.sulamerica.ats.api.service;

import br.com.sulamerica.ats.api.beans.Ats;
import br.com.sulamerica.ats.api.beans.ValidationException;
import br.com.sulamerica.ats.api.utils.ValidaEntrada;

public class ServiceImp {

	public boolean trataEntrada(Ats ats) {

		try {
			ValidaEntrada valida = new ValidaEntrada();
			valida.validaCodigoAts(ats.getCodigoDaAts());

			valida.validaCodigoDaGuia(ats.getCodigoDaGuia());

			valida.validaNomeDoBeneficiario(ats.getNomeDoBeneficiario());
			// valida.validaDataDePagamento(ats.getDataDePagamento());

			valida.validaTotalGlosado(ats.getTotalGlosado());

			valida.validaTamanhoPDF(ats.getFilePDF().getTamanhoPdf());

			valida.validaArquivoBase64(ats.getFilePDF().getArquivoBase64());
			
			return true;

		} catch (ValidationException e) {
			return false;
		}
	}

}
