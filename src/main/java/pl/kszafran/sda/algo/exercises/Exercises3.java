package pl.kszafran.sda.algo.exercises;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Zaimplementuj poniższe algorytmy wyszukiwania.
 */
public class Exercises3 {

    /**
     * Wyszukuje element o wartości value w podanej tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     */
    public int linearSearch(int[] array, int value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     */
    public int binarySearch(int[] array, int value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ liście i zwraca jego indeks.
     */
    public <T> Optional<Integer> indexOf(List<T> list, T value, Comparator<T> comparator) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Wyszukuje wszystkie elementy o wartości value w podanej POSORTOWANEJ tablicy i zwraca zakres ich indeksów.
     * <p>
     * Uwaga: istnieją dwie możliwe implementacje, jedna o stałej złożoności O(log n)
     * oraz druga, która potrafi zdegradować się do złożoności O(n) w najgorszym przypadku.
     */
    public Optional<IntRange> binarySearchRange(int[] array, int value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     * <p>
     * Uwaga: należy zastosować wyszukiwanie interpolacyjne (interpolation search).
     */
    public int interpolationSearch(int[] array, int value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static class IntRange {

        private final int start;
        private final int end;

        public IntRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    /**
     * Znajduje wszystkie pliki o nazwie pasującej do podanego wyrażenia regularnego
     * w podanym katalogu i wszystkich jego podkatalogach.
     * <p>
     * Zwrócone pliki są posortowane alfabetycznie po pełnej ścieżce (nie tylko nazwie pliku).
     * <p>
     * Jeśli directory wskazuje na plik, zwrócona lista ma zawierać tylko ten plik
     * (jeśli jego nazwa pasuje do wyrażenia regularnego).
     * <p>
     * Uwaga: należy skupić się na klasach z pakietu java.io.
     */
    public List<File> findFiles(File directory, String regex) throws IOException {
        ArrayList<File> result = new ArrayList<File>();
        File[] arrayFiles = directory.listFiles();
        if (!directory.exists())
            return result;
        if (directory.isFile())
            result.add(directory);
        for (File arrayFile : arrayFiles != null ? arrayFiles : new File[0]) {
            if (arrayFile.isDirectory()) result.addAll(findFiles(arrayFile, regex));
            if (arrayFile.getName().matches(regex)) result.add(arrayFile);
        }
        result.sort(Comparator.comparing(e -> e.getAbsolutePath()));
        return result;
//        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Działa tak samo jak findFiles().
     * <p>
     * Uwaga: należy korzystac z dobrodziejstw pakietu java.nio.file.
     */
    public Stream<Path> findFilesNIO(Path directory, Pattern regex) throws IOException {
        if (!Files.exists(directory)) {
            return Stream.empty();
        }
        return Files.walk(directory)
                .filter(path -> regex.matcher(path.getFileName().toString()).matches())
                .sorted();
//        throw new UnsupportedOperationException("Not implemented yet");
    }
}
