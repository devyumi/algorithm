package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class No1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int result = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, Collections.reverseOrder());
        String tmp = arr[0];
        for (int i = 1; i < n; i++) {
            if (tmp.length() >= arr[i].length()) {
                if (!tmp.substring(0, arr[i].length()).equals(arr[i])) {
                    tmp = arr[i];
                    result++;
                }
            } else {
                if (!arr[i].substring(0, tmp.length()).equals(tmp)) {
                    tmp = arr[i];
                    result++;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}