package boj.dp;

import java.io.*;

public class No1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                if (j * j == i) {
                    min = 1;
                    break;
                }
                min = Math.min(min, dp[j] + dp[i - j]);
            }
            dp[i] = min;
        }
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}