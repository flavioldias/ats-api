package br.com.sulamerica.ats.api.security;

import br.com.sulamerica.ats.api.security.dto.MensagemErroDTO;
import br.com.sulamerica.ats.api.security.service.OAuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;

@RestController
@Lazy(value = true)
@RequestMapping("oauth")
public class OAuthTokenController {
	
	@Autowired
	private OAuthService oAuthService;
	
	@PermitAll
	@RequestMapping(value = "token" ,method = RequestMethod.POST , consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public String authorize(HttpServletRequest request, @RequestHeader(value="Authorization") String authorization) throws JsonProcessingException {
		try {
			return oAuthService.createJsonResponseToken(authorization);			
		} catch (Exception e) {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(new MensagemErroDTO(e.getLocalizedMessage()));
		}

	  }

}
