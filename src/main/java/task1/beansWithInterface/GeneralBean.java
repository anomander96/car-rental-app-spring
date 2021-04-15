package task1.beansWithInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import task1.MyBean;

import java.io.Serializable;
import java.util.List;

@Component
public class GeneralBean implements Serializable {

    @Autowired
    private List<MyBean> beanServices;

    private MyBean beanImplA = new BeanImplA();

    @Qualifier("beanImplB")
    private MyBean beanImplB = new BeanImplB();

    @Qualifier("beanImplC")
    private MyBean beanImplC = new BeanImplC();

    public void printBeans() {
        for (MyBean bean : beanServices) {
            bean.doSomething();
        }
    }
}
