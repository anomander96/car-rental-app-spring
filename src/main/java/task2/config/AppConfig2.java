package task2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import task2.beans.BeanA;
import task2.beans.BeanE;
import task2.beans.BeanF;

@Configuration
@Import(AppConfig1.class)
public class AppConfig2 {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }
}