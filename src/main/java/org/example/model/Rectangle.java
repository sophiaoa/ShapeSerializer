package org.example.model;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("⬛ Малюємо прямокутник");
    }

    @Override
    public String toString() {
        return "Прямокутник | колір: " + shapeColor + ", площа: " + calcArea();
    }
}
