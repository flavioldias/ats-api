package br.com.sulamerica.ats.api.security.service;

import br.com.sulamerica.ats.api.security.TokenCacheManager;
import br.com.sulamerica.ats.api.security.dao.OAuthDAOImpl;
import br.com.sulamerica.ats.api.security.dto.OAuthClientDetailsDTO;
import br.com.sulamerica.ats.api.security.utils.OAuthUtils;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.servlet.http.HttpServletResponse;

@Service
@Lazy
public class OAuthServiceImpl implements OAuthService {
	
	@Autowired
	private OAuthDAOImpl oAuthDao;
	
	public void save(OAuthClientDetailsDTO details) {
		oAuthDao.save(details);
	}
	
	public OAuthClientDetailsDTO findByClientId(String clientId) {
		return oAuthDao.findByClientId(clientId);
	}

	@Override
	public String createJsonResponseToken(String authentication) throws Exception {
		
		if (authentication == null || authentication.equals("")) {
			throw new RuntimeException("Header Authentication vazio.");
		}
		
		String[] arrayUserPass  = OAuthUtils.decodeAutentication(authentication);
		String clientId = arrayUserPass[0];

		if (arrayUserPass.length < 2) {
			throw new RuntimeException("Usuário e senha no padrão inválido (" +clientId+ ").");
		}
		String clientSecret = arrayUserPass[1];

		OAuthClientDetailsDTO oAuthClientDetails = this.findByClientId(clientId);
		
		String responseBody = "";
		if (oAuthClientDetails.getClientSecret() != null) {
			if (oAuthClientDetails.getClientSecret().equals(clientSecret)) {
				OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
				
				final String accessToken = oauthIssuerImpl.accessToken();
				if (saveToken(oAuthClientDetails.getClientId(), accessToken)) {
					OAuthResponse response = OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK)
							.setAccessToken(accessToken)
							.setExpiresIn(oAuthClientDetails.getExpiresTime().toString())
							.setTokenType(oAuthClientDetails.getTokenType())
							.buildJSONMessage();
					
					responseBody = response.getBody();		
					
				}
				return responseBody;
				
			} else {
				throw new RuntimeException("Senha incorreta. Tente novamente.");
			}
			
		} else {
			throw new RuntimeException("Usuário " + clientId + " inválido.");
		}
		
	}
	
	@SuppressWarnings({"unchecked"})
	private boolean saveToken(String clientId, String token) {
        try {
    		Cache cache = TokenCacheManager.getInstance().getCache();
            cache.put(token, clientId);
        } catch (CacheException e) {
        	return false;
        }		
		
		return true;
	
	}


}
