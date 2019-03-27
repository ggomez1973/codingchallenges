package com.ggomez1973.coffeeclient;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int v = 0;     // # of valleys
        int lvl = 0;   // current level
        for(char c : s.toCharArray()){
            if(c == 'U') ++lvl;
            if(c == 'D') --lvl;

            // if we just came UP to sea level
            if(lvl == 0 && c == 'U')
                ++v;
        }
        System.out.print(v);




        int index = s.indexOf("UD");

        Stream<String> stream = Arrays.stream(s.split(""));
        stream.forEach(step -> {
            int deep = 0;
            switch (step){
                case "d":
                    deep+=1;
                    break;
                case "u":
                    deep-=1;
                    break;
            }
            if(deep == 0){

            }
        });
        return index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("cacho.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
