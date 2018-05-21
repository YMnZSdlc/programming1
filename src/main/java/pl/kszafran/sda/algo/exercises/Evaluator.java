package pl.kszafran.sda.algo.exercises;

import java.util.ArrayDeque;
import java.util.Deque;

public class Evaluator {


    public int evaluate(String expression) {
        String[] array;
        array = expression.split("\\s+");
        arrayToPostfix(array);
        return 0;
    }

    private Deque<String> arrayToPostfix(String[] array) {
        Deque<String> output = new ArrayDeque<String>();
        Deque<String> stack = new ArrayDeque<String>();

        for (String s : array) {
            if (s.matches("\\d+")){
                stack.offer(s);
            }
            

        }
        return null;

    }


}
