package br.com.sulamerica.ats.api.security;

import com.google.appengine.api.memcache.stdimpl.GCacheFactory;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.cache.CacheFactory;
import javax.cache.CacheManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TokenCacheManager {

	private static TokenCacheManager instance = null;

	private static Cache cache;
	
	private TokenCacheManager(){}
	
	public static TokenCacheManager getInstance() throws CacheException {
		if (instance == null) {
            CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
            Map properties = new HashMap<>();
            properties.put(GCacheFactory.EXPIRATION_DELTA, TimeUnit.HOURS.toSeconds(1));         
            cache = cacheFactory.createCache(properties);
            instance = new TokenCacheManager();
		}
		
		return instance;
	}
	
	public Cache getCache() {
		return this.cache;
	}		
}