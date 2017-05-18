package br.com.sulamerica.ats.api.security.service;

import br.com.sulamerica.ats.api.security.dto.OAuthClientDetailsDTO;


public interface OAuthService {
	
	public void save(OAuthClientDetailsDTO oAuthClientDetailsCloudTransfer);
	
	public OAuthClientDetailsDTO findByClientId(String clientId);
	
	public String createJsonResponseToken(String clientId) throws Exception;

}
