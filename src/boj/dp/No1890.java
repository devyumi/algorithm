package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class No1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > 0 && arr[i][j] != 0) {
                    if (i + arr[i][j] < n) {
                        dp[arr[i][j] + i][j] += dp[i][j];
                    }
                    if (j + arr[i][j] < n) {
                        dp[i][arr[i][j] + j] += dp[i][j];
                    }
                }

            }
        }
        bw.write(String.valueOf(dp[n - 1][n - 1]));
        bw.close();
    }
}