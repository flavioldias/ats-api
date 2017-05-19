package br.com.sulamerica.ats.api.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Ats {
	
	private String codigoDaAts;	
	private Integer codigoDaGuia;	
	private String nomeDoBeneficiario;
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone = "America/Sao_Paulo")
	private Date dataDePagamento;	
	private Integer totalGlosado;	
	private FilePDF filePDF; 
	
	public String getCodigoDaAts() {
		return codigoDaAts;
	}

	public void setCodigoDaAts(String codigoDaAts) {
		this.codigoDaAts = codigoDaAts;
	}

	public int getCodigoDaGuia() {
		return codigoDaGuia;
	}

	public void setCodigoDaGuia(Integer codigoDaGuia) {
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

	public Integer getTotalGlosado() {
		return totalGlosado;
	}

	public void setTotalGlosado(Integer totalGlosado) {
		this.totalGlosado = totalGlosado;
	}

	public FilePDF getFilePDF() {
		return filePDF;
	}

	public void setFilePDF(FilePDF filePDF) {
		this.filePDF = filePDF;
	}	
}
