package br.com.sulamerica.ats.api.security.dao;

import br.com.sulamerica.ats.api.security.dto.OAuthClientDetailsDTO;

public interface OAuthDAO extends SecurityObjectifyGenericDAO<OAuthClientDetailsDTO> {

	public OAuthClientDetailsDTO findByClientId(String clientId);

}
