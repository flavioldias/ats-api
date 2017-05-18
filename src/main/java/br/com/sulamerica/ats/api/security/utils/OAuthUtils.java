package br.com.sulamerica.ats.api.security.utils;

import org.springframework.util.Base64Utils;

import java.nio.charset.Charset;

public class OAuthUtils {
	
	public static String[] decodeAutentication(String authentication) {
		String base64Credentials = authentication.substring("Basic".length()).trim();		
		String userPass = new String(Base64Utils.decodeFromString(base64Credentials), Charset.forName("UTF-8"));
		String[] arrayUserPass = userPass.split(":", 2);
		
		return arrayUserPass;
	}

}
