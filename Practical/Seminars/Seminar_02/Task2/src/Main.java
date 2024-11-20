//Задание №5
//        Напишите метод, который вернет содержимое текущей папки в виде
//            массива строк.
//        Напишите метод, который запишет массив, возвращенный предыдущим
//            методом в файл.
//        Обработайте ошибки с помощью try-catch конструкции. В случае
//            возникновения исключения, оно должно записаться в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Log.log(Main.class.getName());

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFileNamesInDir(".")));
        writeFileNamesToFile(".", "Task_002.txt");
    }

    public static String[] getFileNamesInDir(String path) {
        //Метод, который вернет содержимое текущей папки в виде массива строк.
        File dir = new File(path);
        String[] res = new String[0];
        File[] files;
        if (dir.isDirectory()) {
            files = dir.listFiles();
            if (files != null) {
                res = new String[files.length];
                for (int i = 0; i < files.length; i++) {
                    File f = files[i];
                    String name = f.getName();
                    res[i] = name;
                }
            }
        } else {
            System.out.println(dir.getName() + " не является папкой.");
        }
        return res;
    }

    public static void writeFileNamesToFile(String outPath, String inPath) {
        //Метод, который запишет массив, возвращенный предыдущим методом в файл.
        String[] arr = getFileNamesInDir(outPath);
        try {
            FileWriter fw = new FileWriter(inPath); // FileWriter(inPath, true) написать так если надо дозаписывать файл.
            for (int i = 0; i < arr.length; i++) {
                fw.write(arr[i] + "\n");
            }
            fw.flush();
            if (isThrow()) {
                throw new IOException("Фатальная ошибка записи!");
            }
        } catch (IOException e) {
            //Обработка ошибок с помощью try-catch конструкции. В случае возникновения исключения, оно запишется в лог-файл.
            System.out.println("Ошибка записи!");
            logger.log(Level.INFO, "Привет :)");
        }
    }

    private static boolean isThrow() {
        int a = 0;
        int b = 2;
        int digit = a + (int) (Math.random() * b);
        System.out.println(digit);
        return digit > 0;
    }
}