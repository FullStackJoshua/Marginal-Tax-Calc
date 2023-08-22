package edu.citytech.financial.utility;



import org.apache.poi.ss.formula.functions.T;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class ReadFileUtility {

    public static <T> List<T> process(String fileName) {
        return process(fileName, (String e) -> (T)e);
    }

    public static <T> List<T> process(String fileName, Function<String, T> function) {

        List<T> list = new ArrayList<>();
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(fileName));
            lines.forEach(e -> {
                list.add( function.apply(e));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}

