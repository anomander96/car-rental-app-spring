package task1.beans3;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BeanF implements Serializable {

    private int id;
    private double size;

    public BeanF() {
    }

    public int getId() {
        return id;
    }

    public double getSize() {
        return size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
