package pl.kszafran.sda.algo.exercises.homework;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Homework1 {
    public static void main(String[] args) {

        List<Long> test = new ArrayList<>();
        test.add(2L);
        test.add(3L);
        test.add(5L);

        System.out.println(doubleNumber(test));

    }

    //Łatwe: (Stream) Zaimplementuj funkcję, która przyjmuje listę liczb (List<Long>)
    //i zwraca NOWĄ listę z każdą liczbą pomnożoną przez 2.

    public static List<Long> doubleNumber(List<Long> numbers) {
//        ArrayList<Long> result = new ArrayList<>();
//        numbers.stream()
//                .map(e -> numbers.add(e * 2));
        return numbers;
    }

}
