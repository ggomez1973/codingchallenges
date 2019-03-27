package com.ggomez1973.coffeeclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FreqQuery {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        /*
        List<Integer> result = new ArrayList<>();
        Map<Integer, Long> data = new HashMap<>();
        Map<Integer, Long> counts = data.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        HashMap<Integer, Function<Integer, ?>> mapa = new HashMap<>();
        mapa.put(1, o -> data.put(o,1L));
        mapa.put(2, o -> data.remove(o));
        mapa.put(3, o -> {
            System.out.println("sdsds");
            //return //result.add(counts.containsValue((long)o)? 1:0);

        });
        queries.forEach(tupla -> {
            mapa.get(tupla.get(0)).apply(tupla.get(1));
        });*/
        return  null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
