package org.example.model;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("🔺 Малюємо трикутник");
    }

    @Override
    public String toString() {
        return "Трикутник | колір: " + shapeColor + ", площа: " + calcArea();
    }
}
