package task1.beansWithInterface;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import task1.MyBean;

import java.io.Serializable;

@Component
@Order(2)
public class BeanImplB implements MyBean, Serializable {

    private String name;
    private double size;

    public BeanImplB() {
    }

    @Override
    public void doSomething() {
        System.out.println("Some action for beanImplB");
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
