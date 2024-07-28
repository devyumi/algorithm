package boj.implementation;

import java.io.*;

public class No18406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("");
        int left = 0;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i <= (arr.length - 1) / 2) {
                left += Integer.parseInt(arr[i]);
            } else {
                right += Integer.parseInt(arr[i]);
            }
        }

        if (left == right) {
            bw.write("LUCKY");
        } else {
            bw.write("READY");
        }
        bw.close();
    }
}