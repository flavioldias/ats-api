package br.com.sulamerica.ats.api.security;

import br.com.sulamerica.ats.api.security.dto.OAuthClientDetailsDTO;
import br.com.sulamerica.ats.api.security.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@Lazy(value = true)
@RequestMapping("oauthclient")
public class OAuthClientController {
	
	@Autowired
	private OAuthService oAuthService;
	
	@PermitAll
	@RequestMapping(value = "save" ,method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(@RequestBody OAuthClientDetailsDTO oAuthClientDetails) {
		oAuthService.save(oAuthClientDetails);
	}
	
	

}
