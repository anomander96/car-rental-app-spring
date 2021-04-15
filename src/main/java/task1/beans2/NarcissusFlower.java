package task1.beans2;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NarcissusFlower implements Serializable {

    private boolean isHealthy;
    private String color;

    public NarcissusFlower() {
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean isHealthy) {
        this.isHealthy = isHealthy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
