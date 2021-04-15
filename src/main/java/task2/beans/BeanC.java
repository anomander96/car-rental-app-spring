package task2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanC {

    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    public BeanC() {}

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
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void customInitMethod() {
        System.out.println("customInitMethod in BeanC is running");
    }

    public void customDestroyMethod() {
        System.out.println("customDestroyMethod in BeanC is running");
    }
}
