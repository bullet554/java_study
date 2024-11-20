//Задание №1
//Заполнить список десятью случайными числами.
//Отсортировать список методом sort() и вывести его на
//экран.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rdm = new Random();
        int size = 10;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(rdm.nextInt());
        }
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}