//Задание 1. Формирование URL с параметрами
//Дана строка базового URL:
//https://example.com/search?
//Сформируйте полный URL, добавив к нему параметры для поиска. Параметры
//передаются в виде строки, где ключи и значения разделены =, а пары
//ключ-значение разделены &. Если значение null, то параметр не должен
//попадать в URL.
//        Пример:
//params = "query=java&sort=desc&filter=null"
//Результат:
//https://example.com/search?query=java&sort=desc

public class URLBuilder {
    public static void main(String[] args) {
        String baseUrl = "https://example.com/search?";
        String params = "query=java&sort=desc&filter=null";

        String fullUrl = buildUrl(baseUrl, params);
        System.out.println(fullUrl);
    }

    public static String buildUrl(String baseUrl, String params) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        String[] pairs = params.split("&"); // Подсказка 1: Разделяем строку параметров на части

        boolean firstParam = true; // Флаг для отслеживания первого параметра

        // Проверяем, есть ли символ ? в базовом URL
        boolean hasQuestionMark = baseUrl.contains("?");

        for (String pair : pairs) {
            String[] keyValue = pair.split("="); // Подсказка 2: Разделяем на ключ и значение
            String key = keyValue[0];
            String value = keyValue.length > 1 ? keyValue[1] : null;

            // Подсказка 3: Проверяем, если значение равно "null"
            if (value != null && !value.equals("null") && !value.isEmpty()) {
                // Подсказка 4: Используем StringBuilder для построения итогового URL
                if (firstParam) {
                    // Если это первый параметр, добавляем ? или &
                    urlBuilder.append(hasQuestionMark ? "&" : "?").append(key).append("=").append(value);
                    firstParam = false; // Устанавливаем флаг в false после первого параметра
                } else {
                    urlBuilder.append("&").append(key).append("=").append(value);
                }
            }
        }

        return urlBuilder.toString();
    }
}
