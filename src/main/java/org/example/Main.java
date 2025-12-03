package org.example;
import org.example.controller.ShapeController;
import org.example.model.*;
import org.example.service.ShapeFileService;
import org.example.view.ShapeView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Початковий список
        List<Shape> shapes = generateRandomShapes(5);

        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);
        ShapeFileService fileService = new ShapeFileService(); // Наш файл сервіс

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Показати фігури");
            System.out.println("2. Згенерувати нові фігури");
            System.out.println("3. Зберегти у файл");
            System.out.println("4. Завантажити з файлу");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> controller.showAllShapes();

                    case "2" -> {
                        shapes = generateRandomShapes(5);
                        // Оновлюємо список у контролері
                        controller = new ShapeController(shapes, view);
                        System.out.println("Згенеровано нові фігури.");
                    }

                    case "3" -> { //ЗБЕРЕЖЕННЯ)
                        System.out.print("Введіть назву файлу для збереження: ");
                        String saveName = scanner.nextLine();
                        fileService.saveShapes(shapes, saveName);
                        System.out.println("Фігури успішно збережено!");
                    }

                    case "4" -> { //ЗАВАНТАЖЕННЯ
                        System.out.print("Введіть назву файлу для читання: ");
                        String loadName = scanner.nextLine();

                        // Читаємо дані файлу
                        List<Shape> loadedShapes = fileService.loadShapes(loadName);
                        System.out.println("\n=== Фігури успішно завантажено з файлу! ===");

                        // Виводимо їх на екран
                        System.out.println("\n=== Вміст файлу " + loadName + " ===");
                        view.displayShapes(loadedShapes);
                    }

                    case "0" -> {
                        System.out.println("До побачення!");
                        return;
                    }
                    default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
                // Обробка коректності через try-catch
            } catch (IOException e) {
                System.out.println("Помилка роботи з файлом: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Помилка: Файл містить невідомі дані.");
            } catch (Exception e) {
                System.out.println("Сталася помилка: " + e.getMessage());
            }
        }
    }

    // Метод генерації
    private static List<Shape> generateRandomShapes(int count) {
        String[] colors = {"червоний", "синій", "жовтий", "зелений"};
        Random random = new Random();
        List<Shape> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int shapeType = random.nextInt(3);
            String color = colors[random.nextInt(colors.length)];

            switch (shapeType) {
                case 0 -> list.add(new Rectangle(color, 1 + random.nextInt(10), 1 + random.nextInt(10)));
                case 1 -> list.add(new Triangle(color, 1 + random.nextInt(10), 1 + random.nextInt(10)));
                case 2 -> list.add(new Circle(color, 1 + random.nextInt(5)));
            }
        }
        return list;
    }
}
