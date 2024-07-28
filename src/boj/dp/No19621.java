package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class No19621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n >= 3) {
            dp[1] = arr[1];
            dp[2] = Math.max(arr[1], arr[2]);
            for (int i = 3; i < n + 1; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            }
        } else if (n == 2) {
            dp[n] = Math.max(arr[1], arr[2]);
        } else if (n == 1) {
            dp[n] = arr[1];
        }

        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}