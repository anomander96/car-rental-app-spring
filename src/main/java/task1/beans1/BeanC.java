package task1.beans1;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BeanC implements Serializable {

    private int id;
    private boolean isActive;

    public BeanC() {
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
