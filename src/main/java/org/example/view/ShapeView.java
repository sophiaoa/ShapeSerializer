package org.example.view;
import org.example.model.Shape;
import java.util.List;

public class ShapeView {
    public void displayShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
