package boj.dp;

import java.io.*;

public class No11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        long answer = 0;

        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += (dp[i - 1][k] % 10007);
                }
            }
        }

        for (long j : dp[n]) {
            answer += j;
        }

        bw.write(String.valueOf(answer % 10007));
        bw.close();
    }
}