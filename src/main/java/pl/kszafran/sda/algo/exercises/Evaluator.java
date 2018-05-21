package pl.kszafran.sda.algo.exercises;

import java.util.ArrayDeque;
import java.util.Deque;

public class Evaluator {


    public int evaluate(String expression) {
        String[] array;
        array = expression.split("\\s+");
        toONP(array);
        return 0;
    }


    private Deque<String> toONP(String[] array) {
        Deque<String> stack = new ArrayDeque<String>();
        Deque<String> output = new ArrayDeque<String>();

        for (String symbol : array) {
            if (symbol.matches("\\d+")){
                output.offer(symbol);
            }

        }

        return null;

    }


}
