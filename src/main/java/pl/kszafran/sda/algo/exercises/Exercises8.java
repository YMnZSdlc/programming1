package pl.kszafran.sda.algo.exercises;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class Exercises8 {

    /**
     * Funkcja zwraca zbiór wartości, które występują więcej niż raz w liście "values".
     *
     * Uwaga: rozwiązanie musi działać w czasie O(n).
     */
    public <T> Set<T> findDuplicates(List<T> values) {
//        if (values.isEmpty()) throw new NullPointerException("Pust lista");
        Set<T> test = new HashSet<>();
        Set<T> result = new HashSet<>();
        for (T str : values) {
            if (test.contains(str)){
                result.add(str);
            }
            else {
                test.add(str);
            }
        }
        return result;


//        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja zwraca mapę przypisującą każdej wartości jej ilość wystąpień w liście "values".
     */
    public <T> Map<T, Integer> countOccurrences(List<T> values) {
        Map<T, Integer> result = new HashMap<>();
        for (T value : values) {
            if (result.containsKey(value)){
                result.replace(value, result.get(value)+1);
            }
            else{
                result.put(value,1);
            }
        }
        return result;

//        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja zwraca zbiór wszystkich wartości występujących w obu podanych listach.
     */
    public <T> Set<T> findCommonValues(List<T> list1, List<T> list2) {
        Set<T> result = new HashSet<>();

        for (T list1Value : list1) {
            if (list2.contains(list1Value)){
                result.add(list1Value);
            }
        }
        return result;


//        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja łączy wartości nagłówków HTTP o tej samej nazwie.
     *
     * Argumentem funkcji jest lista nagłówków HTTP w postaci "nazwa:wartość".
     * Każdy nagłówek znajduje się w osobnej linijce.
     * Nazwa nagłówka nie może zawierać znaku ":".
     *
     * Jeśli nagłówek o tej samej nazwie występuje wielokrotnie, w wartości wynikowej powinien
     * pojawić się tylko raz, a jego wartości powinny zostać złączone znakiem ",".
     *
     * Np. dla:
     *
     * aaa:123
     * bbb:897
     * aaa:432
     *
     * funkcja zwraca:
     *
     * aaa:123,432
     * bbb:897
     *
     * Jeśli ta sama wartość pojawia się wielokrotnie, powinna zostać zamieszczona tylko raz.
     *
     * Np. dla:
     *
     * aaa:123
     * bbb:897
     * aaa:123
     *
     * funkcja zwraca:
     *
     * aaa:123
     * bbb:897
     *
     * Względna kolejność nagłówków musi zostać zachowana.
     * Względna kolejność wartości danego nagłówka musi zostać zachowana.
     *
     * @throws IllegalArgumentException jeśli linijka zawiera niepoprawny nagłówek, puste linie są dopuszczalne
     */
    public String mergeHeaders(String headers) {
        Map<String, String> map = new LinkedHashMap<>();
        for (String header : headers.split("\n")) {
            if (!header.contains(":")) throw new IllegalArgumentException("Bad header");
            String []headArr = header.split(":",2);

            if (map.containsKey(headArr[0])){
                if (!map.get(headArr[0]).equals(headArr[1])){
                    map.replace(headArr[0], (map.get(headArr[0]+ ","+ headArr[1])));
                }
            }
            else{
                map.put(headArr[0],headArr[1]);
            }

        }

        return map.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(joining("\n"));
//        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja działa tak samo jak mergeHeaders, z tym że:
     * - nagłówki zwracane są w kolejności alfabetycznej
     * - wartości danego nagłówka ustawione są w kolejności alfabetycznej
     */
    public String normalizeHeaders(String headers) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
