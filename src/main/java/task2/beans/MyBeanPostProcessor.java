package task2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization method in MyBeanPostProcessor is running");
        System.out.println("Bean: " + bean + ", beanName: " + beanName);

        if (bean instanceof BeanA) {
          ((BeanA) bean).setName("ValidBeanAName");
          ((BeanA) bean).setValue(1);
        } if (bean instanceof BeanF) {
            ((BeanF) bean).setName("ValidBeanFName");
            ((BeanF) bean).setValue(22);
        } if (bean instanceof BeanE) {
            ((BeanE) bean).setName("ValidBeanEName");
            ((BeanE) bean).setValue(333);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization method in MyBeanPostProcessor is running");
        System.out.println("Bean: " + bean + ", beanName: " + beanName);
        return bean;
    }
}
