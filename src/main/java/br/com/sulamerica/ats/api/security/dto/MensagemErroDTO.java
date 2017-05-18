package br.com.sulamerica.ats.api.security.dto;

public class MensagemErroDTO {

	private String mensagem;

	public MensagemErroDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
