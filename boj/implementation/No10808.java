package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10808 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] alphabet = new int[26];

        for (int i = 0; i < input.length; i++) {
            int n = (int) (input[i]);
            alphabet[n - 97]++;
        }
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}