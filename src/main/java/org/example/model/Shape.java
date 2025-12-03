package org.example.model;
import java.io.Serializable;

// Додаємо "implements Serializable"
public abstract class Shape implements Drawable, Serializable {
    protected String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "Фігура кольору: " + shapeColor + ", площа = " + calcArea();
    }
}
