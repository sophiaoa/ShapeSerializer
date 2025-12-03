package org.example.model;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("⚪ Малюємо коло");
    }

    @Override
    public String toString() {
        return "Коло | колір: " + shapeColor + ", площа: " + calcArea();
    }
}
