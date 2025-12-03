package org.example.controller;
import org.example.model.Shape;
import org.example.view.ShapeView;
import java.util.Comparator;
import java.util.List;

public class ShapeController {
    private List<Shape> shapes;
    private ShapeView view;

    public ShapeController(List<Shape> shapes, ShapeView view) {
        this.shapes = shapes;
        this.view = view;
    }

    public void drawAllShapes() {
        view.displayMessage("\n=== Малюємо всі фігури ===");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void showAllShapes() {
        view.displayShapes(shapes);
    }

    public void showTotalArea() {
        double total = shapes.stream().mapToDouble(Shape::calcArea).sum();
        view.displayMessage("\nЗагальна площа всіх фігур: " + total);
    }

    public void showTotalAreaByType(Class<?> type) {
        double total = shapes.stream()
                .filter(s -> s.getClass() == type)
                .mapToDouble(Shape::calcArea)
                .sum();
        view.displayMessage("\nСумарна площа фігур типу " + type.getSimpleName() + ": " + total);
    }

    public void sortByArea() {
        shapes.sort(Comparator.comparingDouble(Shape::calcArea));
        view.displayMessage("\nФігури відсортовані за площею (зростання):");
    }

    public void sortByColor() {
        shapes.sort(Comparator.comparing(Shape::getShapeColor));
        view.displayMessage("\nФігури відсортовані за кольором:");
    }
}
