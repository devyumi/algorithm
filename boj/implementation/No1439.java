package boj.implementation;

import java.io.*;

public class No1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("");

        int resultOne = reverse(arr, 1);
        int resultZero = reverse(arr, 0);

        bw.write(String.valueOf(Math.min(resultOne, resultZero)));
        bw.close();
    }

    private static int reverse(String[] arr, int key) {
        int result = 0;
        if (arr[0].equals(key + "")) {
            result++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(key + "")) {
                if (arr[i - 1].equals(key + "")) {
                    continue;
                } else {
                    result++;
                }
            }
        }
        return result;
    }
}