package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class No1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = 99;
        int[][] dp = new int[n + 1][k + 1];
        int[] happiness = new int[n + 1];
        int[] power = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            happiness[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (power[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], happiness[i] + dp[i - 1][j - power[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        bw.write(String.valueOf(dp[n][k]));
        bw.close();
    }
}