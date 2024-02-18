package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class No1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] < arr[i + 1] + arr[i + 2]) {
                sum = Math.max(sum, arr[i] + arr[i + 1] + arr[i + 2]);
            }
        }

        if (sum == 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(sum));
        }
        bw.close();
    }
}