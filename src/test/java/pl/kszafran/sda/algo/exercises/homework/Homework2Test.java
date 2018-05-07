package pl.kszafran.sda.algo.exercises.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Homework2Test {
    private Homework2 homework = new Homework2();

    @Test
    void test_fibonacci() {
        assertEquals(0,homework.fibonacci(0));
        assertEquals(1,homework.fibonacci(1));
        assertEquals(1,homework.fibonacci(2));
        assertEquals(2,homework.fibonacci(3));
        assertEquals(3,homework.fibonacci(4));
        assertEquals(5,homework.fibonacci(5));
        assertEquals(8,homework.fibonacci(6));
        assertEquals(13,homework.fibonacci(7));
        assertEquals(21,homework.fibonacci(8));
    }
}