package task2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD {

    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    public BeanD() {}

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
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public void customInitMethod() {
        System.out.println("customInitMethod in BeanD is running");
    }

    public void customDestroyMethod() {
        System.out.println("customDestroyMethod in BeanD is running");
    }
}
