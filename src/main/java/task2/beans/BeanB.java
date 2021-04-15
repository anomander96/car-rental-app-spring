package task2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    public BeanB() {}

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void customInitMethod() {
        System.out.println("customInitMethod in BeanB is running");
    }

    public void customDestroyMethod() {
        System.out.println("customDestroyMethod in BeanB is running");
    }

    public void anotherCustomMethod() {
        System.out.println("anotherCustomMethod in BeanB is running");
    }
}
