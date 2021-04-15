package task1.beans3;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BeanD implements Serializable {

    private int id;
    private String text;

    public BeanD() {
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
