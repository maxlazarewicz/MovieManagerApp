package pl.movie.manager.infrastructure.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class ClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
