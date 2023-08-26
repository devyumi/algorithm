package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        for (char c : br.readLine().toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(encodeUpperAlphabet(c));
            } else if (Character.isLowerCase(c)) {
                result.append(encodeLowerAlphabet(c));
            } else {
                result.append(c);
            }
        }
        System.out.println(result);
    }

    private static char encodeUpperAlphabet(int input) {
        if (input + 13 > 90) {
            return (char) (input - 13);
        }
        return (char) (input + 13);
    }

    private static char encodeLowerAlphabet(int input) {
        if (input + 13 > 122) {
            return (char) (input - 13);
        }
        return (char) (input + 13);
    }
}