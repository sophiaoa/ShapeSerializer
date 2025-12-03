package org.example.service;
import org.example.model.Shape;
import java.io.*;
import java.util.List;

public class ShapeFileService {

    // Збереження списку фігур
    public void saveShapes(List<Shape> shapes, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(shapes); // Записуємо весь список разом
        }
    }

    // Завантаження списку фігур
    public List<Shape> loadShapes(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (List<Shape>) ois.readObject(); // Читаємо та перетворюємо назад у список
        }
    }
}
