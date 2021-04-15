package task1.beans3;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BeanE implements Serializable {

    private int id;
    private double value;

    public BeanE() {
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
