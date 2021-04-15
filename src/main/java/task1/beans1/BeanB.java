package task1.beans1;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BeanB implements Serializable {

    private int id;
    private String name;

    public BeanB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
