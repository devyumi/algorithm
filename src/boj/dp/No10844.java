package boj.dp;

import java.io.*;

public class No10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        long answer = 0;

        for (int j = 1; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j < 10; j++) {
                if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        for (long j : dp[n]) {
            answer += j;
        }

        bw.write(String.valueOf(answer % 1000000000));
        bw.close();
    }
}