package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kowalczyk.maciej.spring.learn.repository.QuoteRepository;

@Configuration
public class SpringLearnConfig {

    @Bean
    public QuoteRepository quoteRepository() {
        return new QuoteRepository();
    }
}
