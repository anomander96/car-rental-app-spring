package task1.beansWithInterface;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import task1.MyBean;

import java.io.Serializable;

@Component
@Order(3)
public class BeanImplC implements MyBean, Serializable {

    private int id;
    private String name;

    public BeanImplC() {
    }

    @Override
    public void doSomething() {
        System.out.println("Some action for beanImplC");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
