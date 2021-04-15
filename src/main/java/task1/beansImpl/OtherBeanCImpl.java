package task1.beansImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import task1.otherBeans.OtherBeanC;

import java.io.Serializable;

@Component
public class OtherBeanCImpl implements Serializable {

    @Autowired
    @Qualifier("otherBeanC")
    private OtherBeanC otherBeanC;

    public OtherBeanCImpl() {
    }

    public OtherBeanC getOtherBeanC() {
        return otherBeanC;
    }
}
