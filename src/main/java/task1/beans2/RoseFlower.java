package task1.beans2;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RoseFlower implements Serializable {

    private boolean isHealthy;
    private String color;
    private double price;

    public RoseFlower() {
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
