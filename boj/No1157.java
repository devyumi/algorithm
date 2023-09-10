package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        char[] c = s.toCharArray();
        int[] alphabet = new int[26];
        int result = 0;

        for (char value : c) {
            int idx = (int) value - 65;
            alphabet[idx]++;
        }

        int max = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (max < alphabet[i]) {
                max = alphabet[i];
                result = i + 65;
            } else if (max == alphabet[i] && alphabet[i] != 0) {
                result = '?';
            }
        }
        System.out.print((char) result);
    }
}