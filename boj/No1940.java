package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (arr[start] + arr[end] == m) {
                answer++;
                start++;
                end--;
            } else if (arr[start] + arr[end] < m) {
                start++;
            } else {
                end--;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}