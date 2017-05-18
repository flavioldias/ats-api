package br.com.sulamerica.ats.api.beans;

import java.util.Date;

/**
 * Created by CRG1211 on 12/05/2017.
 */
public class DocumentoAts {

    private Long id;
    private String arquivoBase64;
    private Date dataPagamento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArquivoBase64() {
        return arquivoBase64;
    }

    public void setArquivoBase64(String arquivoBase64) {
        this.arquivoBase64 = arquivoBase64;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
