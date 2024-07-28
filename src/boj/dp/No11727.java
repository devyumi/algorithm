package boj.dp;

import java.io.*;

public class No11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        if (n == 1) {
            bw.write("1");
        } else if (n == 2) {
            bw.write("3");
        } else {
            dp[1] = 1;
            dp[2] = 3;
            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
            }
            bw.write(String.valueOf(dp[n]));
        }
        bw.close();
    }
}