package cn.jianwoo.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.validation.Validator;
import java.util.Locale;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 15:48
 */
@Configuration
public class ValidationConfig {
    @Autowired
    private MessageSource messageSource;
//    @Bean
//    public LocalValidatorFactoryBean defaultValidator(MessageSource messageSource) {
//        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//        factoryBean.setValidationMessageSource(messageSource);
//        return factoryBean;
//    }
    @Bean
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(this.messageSource);
        return validator;
    }
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        // 设置默认的Local为中文
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return  acceptHeaderLocaleResolver;
    }
}
