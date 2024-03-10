package boj.dp;

import java.io.*;

public class No2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n >= 3) {
            dp[0] = arr[0];
            dp[1] = dp[0] + arr[1];

            dp[2] = Math.max(Math.max(dp[1], arr[0] + arr[2]), arr[1] + arr[2]);
            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(Math.max(arr[i] + arr[i - 1] + dp[i - 3], arr[i] + dp[i - 2]), dp[i - 1]);
            }
        } else if (n == 1) {
            dp[n - 1] = arr[0];
        } else if (n == 2) {
            dp[n - 1] = arr[0] + arr[1];
        }

        bw.write(String.valueOf(dp[n - 1]));
        bw.close();
    }
}