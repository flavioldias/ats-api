package br.com.sulamerica.ats.api.security.dao;

import br.com.sulamerica.ats.api.security.dto.OAuthClientDetailsDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

@Repository
@Lazy(value = true)
public class OAuthDAOImpl extends SecurityObjectifyGenericDAOImpl<OAuthClientDetailsDTO> implements OAuthDAO {

	protected OAuthDAOImpl() {
		super(OAuthClientDetailsDTO.class);
	}

	@Override
	public OAuthClientDetailsDTO findByClientId(String clientId) {
		List<OAuthClientDetailsDTO> list = ofy().load().type(OAuthClientDetailsDTO.class).filter("clientId =", clientId).list();
		int size = list.size();
		if (size == 0) {
			return new OAuthClientDetailsDTO();
		}
		return list.get(size - 1);
	}

	
}
