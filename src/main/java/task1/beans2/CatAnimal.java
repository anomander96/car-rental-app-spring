package task1.beans2;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CatAnimal implements Serializable {

    private int age;
    private String name;

    public CatAnimal() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
