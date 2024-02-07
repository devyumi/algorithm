package boj.dp;

import java.io.*;

public class No2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[1] = 1;

        if (n > 1) {
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}