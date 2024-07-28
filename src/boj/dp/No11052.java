package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class No11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}