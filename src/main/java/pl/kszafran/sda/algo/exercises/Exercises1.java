package pl.kszafran.sda.algo.exercises;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.Set;

/**
 * Zaimplementuj poniższe metody Z WYKORZYSTANIEM REKURENCJI.
 */
public class Exercises1 {

    /**
     * Oblicza silnię argumentu n. Zwraca 1 dla n = 0.
     */
    public int factorial(int n) {
        return (n != 0 ? n * factorial(n - 1) : 1);
    }

    /**
     * Oblicza sumę wszystkich liczb w podanej tablicy.
     * Uwaga: aby policzyć sumę rekurencyjnie, potrzebna będzie dodatkowa metoda.
     */
    public int sum(int[] numbers) {
        return sumWithOffSet(numbers, 0);
    }

    private int sumWithOffSet(int[] numbers, int offSet) {
        return (offSet == numbers.length ? 0 : numbers[offSet] + sumWithOffSet(numbers, offSet + 1));
    }

    /**
     * Odwraca podany napis, np. dla "test" zwraca "tset".
     */
    public String reverse(String text) {
        if(text.isEmpty())return "";
        return text.charAt(text.length()-1)+ reverse(text.substring(0,text.length()-1));
    }

    /**
     * Oblicza NWW (najmniejszą wspólną wielokrotnosć) podanych argumentów.
     * <p>
     * (po angielsku LCM - Least Common Multiple)
     * <p>
     * Podpowiedź:
     * NWW(a, b) = a * b / NWD(a, b)
     * NWW(a1, a2, ..., an) = NWW(a1, NWW(a2, a3, ..., an))
     *
     * @throws IllegalArgumentException jeśli któryś z argument jest ujemny lub gdy nie podano żadnych argumentów
     */
    public int lcm(int... numbers) {
//        throw new UnsupportedOperationException("Not implemented yet");
        if (numbers.length==0){
            throw new IllegalArgumentException("Podaj argumenty");
        }
        for (int number : numbers) {
            if (number<0){
                throw new IllegalArgumentException("Argument powinny być dodatnie");
            }
        }
        return nww(numbers,0);
    }

    private int nww(int[]tab,int i){
        if (tab.length-1 == i)return tab[i];
//        return nww2(tab[i], nww(tab,i+1));
        return 0;
    }

//    private int nww2(int a, int b){
//        if (a == 0 || b== 0) return a+b;
//
//    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Zwraca wszystkie możliwe permutacje podanego ciągu (różnych) znaków.
     * Np. dla "123" zwraca ["123", "132", "213", "231", "312", "321"].
     */
    public Set<String> permutations(String string) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
