package task2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private String name;
    private int value;

    public MyBeanFactoryPostProcessor() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(BeanB.class);
        String newInitMethodName = "anotherCustomMethod";
        beanDefinition.setInitMethodName(newInitMethodName);

        ((DefaultListableBeanFactory) configurableListableBeanFactory)
                .registerBeanDefinition("beanB", beanDefinition);

        System.out.println("postProcessBeanFactory method is running");
    }
}
