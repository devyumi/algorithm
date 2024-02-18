package boj;

import java.io.*;
import java.util.Arrays;

public class No2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        long sum = 0;

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int i = n; i > 0; i--) {
            sum += Math.abs(arr[i] - i);
        }

        bw.write(String.valueOf(sum));
        bw.close();
    }
}