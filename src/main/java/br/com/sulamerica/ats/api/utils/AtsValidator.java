package br.com.sulamerica.ats.api.utils;

public interface AtsValidator {

	void validaCodigoAts(String codigoDaAts);

	void validaCodigoDaGuia(Integer codigoDaGuia);

	void validaNomeDoBeneficiario(String nomeDoBeneficiario);

	boolean validaDataDePagamento(String dataDePagamento);

	void validaTotalGlosado(Integer totalGlosado);

	void validaTamanhoPDF(Long tamanhoPDF);

	void validaArquivoBase64(String arquivoBase64);

}
