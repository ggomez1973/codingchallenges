package com.ggomez1973.coffeeclient;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Socks {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Stream<Integer> sarasa = Arrays.stream(ar).boxed();
        Map<Integer, Long> counted = sarasa.collect(Collectors.groupingBy(o-> o, Collectors.counting()));
        Stream<Long> divided = counted.values().stream().map(value -> value/2);
        return divided.mapToInt(i -> i.intValue()).sum();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("cacho.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
