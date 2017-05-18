package br.com.sulamerica.ats.api.security.filter;

import br.com.sulamerica.ats.api.security.TokenCacheManager;
import br.com.sulamerica.ats.api.security.dto.MensagemErroDTO;
import org.json.JSONObject;
import org.springframework.http.MediaType;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthFilter implements Filter {
	
	private static final String AUTHORIZATION = "Authorization";
	private static final String URL_AH = "/_ah/";
	private static final String URL_OAUTH_TOKEN = "/oauth/token";
	private static final String URL_OAUTHCLIENT_SAVE = "/oauthclient/save";
	private static final String URL_SWAGGER = "/swagger-ui.html";
	private static final String URL_SWAGGER_JS = "/webjars";
	private static  final String URL_SWAGGER_RESOURCE = "/swagger-resources";
	private static  final String URL_SWAGGER_WS = "/v2";


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException  {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        
		if (httpRequest.getRequestURI().startsWith(URL_AH) ||
				httpRequest.getRequestURI().startsWith(URL_OAUTH_TOKEN) ||
				httpRequest.getRequestURI().startsWith(URL_OAUTHCLIENT_SAVE) ||
				httpRequest.getRequestURI().startsWith(URL_SWAGGER) ||
				httpRequest.getRequestURI().startsWith(URL_SWAGGER_JS) ||
				httpRequest.getRequestURI().startsWith(URL_SWAGGER_RESOURCE) ||
				httpRequest.getRequestURI().startsWith(URL_SWAGGER_WS)

				)
		{
			chain.doFilter(request, response);

		} else {
						
			String auth = httpRequest.getHeader(AUTHORIZATION);
			if (auth == null) {
				((HttpServletResponse) response).setStatus(401);
				createJsonMessage(response, httpServletResponse, "Não foi definido token de autorização. Defina um header Authorization");
				return;
			}
			
			if (auth.startsWith("Bearer ")) {
				String accessToken = auth.substring("Bearer	".length());
				Cache cache = null;
				try {
					cache = TokenCacheManager.getInstance().getCache();
				} catch (CacheException e) {
					createJsonMessage(response, httpServletResponse, "Ocorreu um erro ao recuperar o cache. Erro: " + e.getMessage());
				}
				
				if (cache.containsKey(accessToken)) {
					chain.doFilter(request, response);
				} else {
					createJsonMessage(response, httpServletResponse, "Token " + accessToken + " inválido.");
				}
				
			} else {
				createJsonMessage(response, httpServletResponse, "Header " + AUTHORIZATION + " não possui o campo Bearer no valor.");
				return;
			}
			
		}
		
	}

	private void createJsonMessage(ServletResponse response, HttpServletResponse httpServletResponse, String mensagem) throws IOException {
		httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
		PrintWriter out = response.getWriter();
		MensagemErroDTO mensagemErroDto = new MensagemErroDTO(mensagem);
		JSONObject jsonObject = new JSONObject(mensagemErroDto);
		out.print(jsonObject.toString());
	}

	@Override
	public void destroy() {
		
	}

}
