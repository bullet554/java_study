//Задача 2. Создание CSV-строки из массива объектов
//Дан массив объектов, где каждый объект представляет собой строку данных, и
//массив заголовков. Создайте строку CSV, где строки данных разделяются новой
//строкой, а значения в строках разделяются запятыми.

public class CSVBuilder {
    public static void main(String[] args) {
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
                {"John", "30", "New York"},
                {"Alice", "25", "Los Angeles"},
                {"Bob", "35", "Chicago"}
        };

        String csvString = createCSV(headers, data);
        System.out.println(csvString);
    }

    public static String createCSV(String[] headers, String[][] data) {
        StringBuilder csvBuilder = new StringBuilder();

        // Подсказка 1: Объединяем заголовки, используя String.join()
        csvBuilder.append(String.join(",", headers)).append("\n");

        // Подсказка 2: Проходим по массиву данных
        for (String[] row : data) {
            // Объединяем элементы строки, используя String.join()
            csvBuilder.append(String.join(",", row)).append("\n");
        }

        // Подсказка 4: Удаляем последний символ новой строки, если он есть
        return csvBuilder.toString().trim(); // Возвращаем итоговую CSV-строку без лишнего перевода строки
    }
}