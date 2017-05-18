package br.com.sulamerica.ats.api.beans;

import java.util.Date;

public class Ats {
	
	private String codigoDaAts;	
	private int codigoDaGuia;	
	private String nomeDoBeneficiario;	
	private Date dataDePagamento;	
	private String totalGlosado;	
	private int tamanhoPdf;	
	private String arquivoBase64;

	
	public String getCodigoDaAts() {
		return codigoDaAts;
	}

	public void setCodigoDaAts(String codigoDaAts) {
		this.codigoDaAts = codigoDaAts;
	}

	public int getCodigoDaGuia() {
		return codigoDaGuia;
	}

	public void setCodigoDaGuia(int codigoDaGuia) {
		this.codigoDaGuia = codigoDaGuia;
	}

	public String getNomeDoBeneficiario() {
		return nomeDoBeneficiario;
	}

	public void setNomeDoBeneficiario(String nomeDoBeneficiario) {
		this.nomeDoBeneficiario = nomeDoBeneficiario;
	}

	public Date getDataDePagamento() {
		return dataDePagamento;
	}

	public void setDataDePagamento(Date dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
	}

	public String getTotalGlosado() {
		return totalGlosado;
	}

	public void setTotalGlosado(String totalGlosado) {
		this.totalGlosado = totalGlosado;
	}

	public int gettamanhoPdf() {
		return tamanhoPdf;
	}

	public void settamanhoPdf(int tamanhoPdf) {
		this.tamanhoPdf = tamanhoPdf;
	}

	public String getarquivoBase64() {
		return arquivoBase64;
	}

	public void setarquivoBase64(String arquivoBase64) {
		this.arquivoBase64 = arquivoBase64;
	}
	
}
