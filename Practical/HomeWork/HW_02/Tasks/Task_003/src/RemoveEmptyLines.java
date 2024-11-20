//Задача 3. Удаление пустых строк из текста
//Дана строка с несколькими строками текста, разделенными переводами строки.
//        Напишите метод, который удаляет все пустые строки из текста.
//Пример:
//line1
//        line2
//line3
//Результат:
//line1
//        line2
//line3

public class RemoveEmptyLines {
    public static void main(String[] args) {
        String text = "line1\n\nline2\n\n\nline3\n\n"; // Пример текста с пустыми строками
        String result = removeEmptyLines(text);
        System.out.println(result);
    }

    public static String removeEmptyLines(String text) {
        // Подсказка № 1: Разделяем текст на массив строк
        String[] lines = text.split("\n");

        // Подсказка № 3: Используем StringBuilder для создания результата
        StringBuilder resultBuilder = new StringBuilder();
        boolean isFirstLine = true; // Флаг для отслеживания первой строки

        // Подсказка № 2: Проходим по массиву строк
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Проверяем, что строка не пустая
                if (!isFirstLine) {
                    resultBuilder.append("\n"); // Добавляем перевод строки перед каждой непустой строкой, кроме первой
                }
                resultBuilder.append(line); // Добавляем непустую строку
                isFirstLine = false; // Устанавливаем флаг в false после первой строки
            }
        }

        // Подсказка № 4: Возвращаем итоговую строку
        return resultBuilder.toString(); // Возвращаем результат в виде строки
    }
}