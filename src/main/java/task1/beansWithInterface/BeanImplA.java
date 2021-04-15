package task1.beansWithInterface;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import task1.MyBean;

import java.io.Serializable;


@Component
@Primary
@Order(1)
public class BeanImplA implements MyBean, Serializable {

    private String name;
    private String value;

    public BeanImplA() {
    }

    @Override
    public void doSomething() {
        System.out.println("Some action for beanImplA");
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
