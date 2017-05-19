package br.com.sulamerica.ats.api.beans;

public class FilePDF {
	
	private Long tamanhoPdf;
	private String arquivoBase64;
	
	public long getTamanhoPdf() {
		return tamanhoPdf;
	}
	public void setTamanhoPdf(long tamanhoPdf) {
		this.tamanhoPdf = tamanhoPdf;
	}
	public String getArquivoBase64() {
		return arquivoBase64;
	}
	public void setArquivoBase64(String arquivoBase64) {
		this.arquivoBase64 = arquivoBase64;
	}

}
