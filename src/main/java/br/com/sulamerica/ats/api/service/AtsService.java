package br.com.sulamerica.ats.api.service;

import br.com.sulamerica.ats.api.beans.Ats;

public interface AtsService {

	void trataEntrada(Ats ats);

	void pdfGeneration(Ats ats);

}
