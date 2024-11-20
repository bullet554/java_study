//Задача 4. Логирование операций с массивом во время поиска
//        минимального и максимального элементов
//        Реализуйте метод поиска минимального и максимального элементов массива.
//        После нахождения каждого элемента (минимального и максимального),
//        сделайте запись в лог-файл log.txt в формате год-месяц-день
//        час:минуты {минимальный элемент}, {максимальный элемент}.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MinMaxLogger {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 4, 9, 2}; // Пример массива
        findMinMax(numbers);
    }

    public static void findMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Массив пустой или не инициализирован.");
            return;
        }

        // Создаем файл log.txt, если он не существует
        File logFile = new File("log.txt");
        try {
            if (logFile.createNewFile()) {
                System.out.println("Файл log.txt был создан.");
            } else {
                System.out.println("Файл log.txt уже существует.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
            return;
        }

        int min = numbers[0];
        int max = numbers[0];

        // Поиск минимального и максимального элементов
        for (int number : numbers) {
            if (number < min) {
                min = number;
                logStep(min, max); // Логируем минимальный элемент
            }
            if (number > max) {
                max = number;
                logStep(min, max); // Логируем максимальный элемент
            }
        }
    }

    private static void logStep(int min, int max) {
        // Форматируем текущую дату и время
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String timestamp = formatter.format(new Date());

        // Формируем строку для записи в лог
        String logEntry = String.format("%s {%d}, {%d}%n", timestamp, min, max);

        // Записываем в файл
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(logEntry); // Записываем строку в файл
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}