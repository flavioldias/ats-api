package br.com.sulamerica.ats.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.sulamerica.ats.api.beans.Ats;
import br.com.sulamerica.ats.api.utils.AtsValidator;
import br.com.sulamerica.ats.api.utils.PdfGenerator;

@Service
@Lazy(true)
public class AtsServiceImpl implements AtsService {
	
	@Autowired
	private AtsValidator validator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
    
	@Override
	public void trataEntrada(Ats ats) {

		validator.validaCodigoAts(ats.getCodigoDaAts());

		validator.validaCodigoDaGuia(ats.getCodigoDaGuia());

		validator.validaNomeDoBeneficiario(ats.getNomeDoBeneficiario());
		// valida.validaDataDePagamento(ats.getDataDePagamento());

		validator.validaTotalGlosado(ats.getTotalGlosado());

		validator.validaTamanhoPDF(ats.getFilePDF().getTamanhoPdf());

		validator.validaArquivoBase64(ats.getFilePDF().getArquivoBase64());

	}
	
	@Override
	public void pdfGeneration(Ats ats){
		
		pdfGenerator.geraPdf(ats.getFilePDF().getArquivoBase64());
		
	}

}
