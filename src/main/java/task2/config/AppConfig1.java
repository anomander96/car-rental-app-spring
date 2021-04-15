package task2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import task2.beans.*;

@Configuration
@PropertySource("app.properties")
public class AppConfig1 {

    private String name;
    private int value;

    @Bean(initMethod = "customInitMethod",
          destroyMethod = "customDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean
    public static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}