package task2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean {

    private String name;
    private int value;

    public BeanA() {}

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
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    // method from InitializingBean interface
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("method afterPropertiesSet in BeanA is running");
    }

    // method from DisposableBean interface
    @Override
    public void destroy() throws Exception {
        System.out.println("method destroy in BeanA is running");
    }
}
