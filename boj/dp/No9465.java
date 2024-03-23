package boj.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[3][n + 1];
            int[][] dp = new int[3][n + 1];

            for (int i = 1; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n + 1; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];
            for (int j = 2; j < n + 1; j++) {
                dp[1][j] = Math.max(dp[2][j - 1], dp[2][j - 2]) + arr[1][j];
                dp[2][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[2][j];
            }

            sb.append(Math.max(Arrays.stream(dp[1]).max().getAsInt(), Arrays.stream(dp[2]).max().getAsInt())).append("\n");
        }
        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.close();
    }
}