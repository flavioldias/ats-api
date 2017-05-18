package br.com.sulamerica.ats.api;

import br.com.sulamerica.ats.api.cache.GaeCache;
import br.com.sulamerica.ats.api.cache.GaeCacheKeyGenerator;
import br.com.sulamerica.ats.api.cache.GaeCacheManager;
import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;



@Configuration
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
@ComponentScan(basePackages="br.com.sulamerica")
public class Application  extends SpringBootServletInitializer implements CachingConfigurer {



    @Value(value = "${cache.expiration.timeseconds}")
    private Integer expirationTime;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }



    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean
    public CacheManager cacheManager() {
        GaeCacheManager cacheManager = new GaeCacheManager(Expiration.byDeltaSeconds(expirationTime));
        cacheManager.addCache(new GaeCache("default", MemcacheServiceFactory.getMemcacheService(), Expiration.byDeltaSeconds(expirationTime)));
        return cacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        //TODO: verificar o que implementar
        return null;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        GaeCacheKeyGenerator generator = new GaeCacheKeyGenerator();
        return generator;
    }

    @Override
    public CacheErrorHandler errorHandler() {
        //TODO: verificar o que implementar
        return null;
    }

}
