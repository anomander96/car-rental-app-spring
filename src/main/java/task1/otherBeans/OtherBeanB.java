package task1.otherBeans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class OtherBeanB implements Serializable {

    private String name;
    private double value;

    public OtherBeanB() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
