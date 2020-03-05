package config;

import aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import service.Worker;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public Worker worker() {
        return new Worker();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
