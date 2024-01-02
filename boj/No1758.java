package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class No1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (arr[i] - i <= 0) {
                break;
            }
            max += arr[i] - i;
        }

        bw.write(String.valueOf(max));
        bw.close();
    }
}