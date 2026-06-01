package com.globalsolution.java.celticstech.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(
                "agricultores",
                "agricultoresById",
                "cultivos",
                "cultivosById",
                "regioes",
                "regioesById",
                "associacoes",
                "associacoesById",
                "cultivosDoAgricultor",
                "agricultoresDaAssociacao",
                "contatos",
                "contatosById"

        );
    }
}