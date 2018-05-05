package pl.kszafran.sda.algo.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Exercises3 {

    /**
     * Znajduje wszystkie pliki o nazwie pasującej do podanego wyrażenia regularnego
     * w podanym katalogu i wszystkich jego podkatalogach.
     *
     * Zwrócone pliki są posortowane alfabetycznie po pełnej ścieżce (nie tylko nazwie pliku).
     *
     * Jeśli directory wskazuje na plik, zwrócona lista ma zawierać tylko ten plik
     * (jeśli jego nazwa pasuje do wyrażenia regularnego).
     *
     * Uwaga: należy skupić się na klasach z pakietu java.io.
     */
    public List<File> findFiles(File directory, String regex) throws IOException  {
        ArrayList<File> result = new ArrayList<File>();
        File [] arrayFiles = directory.listFiles();
        if (!directory.exists())
            return result;
        if (directory.isFile())
            result.add(directory);
        for (File arrayFile : arrayFiles != null ? arrayFiles : new File[0]) {
            if (arrayFile.isDirectory()) result.addAll(findFiles(arrayFile,regex));
            if (arrayFile.getName().matches(regex)) result.add(arrayFile);
        }
        result.sort(Comparator.comparing(e -> e.getAbsolutePath()));
        return result;
//        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Działa tak samo jak findFiles().
     *
     * Uwaga: należy korzystac z dobrodziejstw pakietu java.nio.file.
     */
    public Stream<Path> findFilesNIO(Path directory, Pattern regex) throws IOException {
        if(Files.exists(directory)){
            return Stream.empty();
        }

        return Files.walk(directory)
                .filter(path -> regex.matcher(path.getFileName().toString()).matches())
                .sorted();

//        throw new UnsupportedOperationException("Not implemented yet");
    }
}
