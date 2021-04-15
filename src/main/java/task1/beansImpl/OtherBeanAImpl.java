package task1.beansImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task1.otherBeans.OtherBeanA;

import java.io.Serializable;

@Component
public class OtherBeanAImpl implements Serializable {

    private OtherBeanA otherBeanA;
    private String name;

    @Autowired
    public OtherBeanAImpl(OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
