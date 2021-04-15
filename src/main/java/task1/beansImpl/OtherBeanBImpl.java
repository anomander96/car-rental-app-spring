package task1.beansImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task1.otherBeans.OtherBeanB;

import java.io.Serializable;

@Component
public class OtherBeanBImpl implements Serializable {
    private OtherBeanB otherBeanB;
    private int id;

    public OtherBeanBImpl() {
    }

    @Autowired
    public void setOtherBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
