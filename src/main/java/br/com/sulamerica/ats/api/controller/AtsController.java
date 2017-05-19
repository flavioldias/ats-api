package br.com.sulamerica.ats.api.controller;

import br.com.sulamerica.ats.api.beans.Ats;
import br.com.sulamerica.ats.api.utils.ValidaEntrada;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "ats-api")
@Lazy(value = true)
public class AtsController {

	@RequestMapping(value = "upload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean upload(@RequestBody Ats ats) {
 
		ValidaEntrada valida = new ValidaEntrada();
		
		if (!valida.validaCodigoAts(ats.getCodigoDaAts())){
			return false;
		}
		
		if (!valida.validaCodigoDaGuia(ats.getCodigoDaGuia())){
			return false;
		}
		
		if (!valida.validaNomeDoBeneficiario(ats.getNomeDoBeneficiario())){
			return false;
		}
		//valida.validaDataDePagamento(ats.getDataDePagamento());
		if (!valida.validaTotalGlosado(ats.getTotalGlosado())){
			return false;
		}
		
		if(!valida.validaTamanhoPDF(ats.getFilePDF().getTamanhoPdf())){
			return false;
		}
		
		if(!valida.validaArquivoBase64(ats.getFilePDF().getArquivoBase64())){
			return false;
		}
		
		return true;
	}

}
