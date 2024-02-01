package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import pl.kowalczyk.maciej.spring.learn.repository.QuoteRepository;

@Configuration
public class SpringLearnConfig {

    @Bean
    public QuoteRepository quoteRepository() {
        return new QuoteRepository();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:form_error_messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
