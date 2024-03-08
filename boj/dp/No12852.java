package boj.dp;

import java.io.*;

public class No12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, Math.min(dp[i / 3] + 1, dp[i - 1] + 1));
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        bw.write(dp[n] + "\n");
        sb.append(n).append(" ");
        while (n > 1) {
            int min = dp[n];

            if (n % 2 == 0 && min > dp[n / 2]) {
                n /= 2;
            } else if (n % 3 == 0 && min > dp[n / 3]) {
                n /= 3;
            } else {
                n -= 1;
            }
            sb.append(n).append(" ");
        }
        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.close();
    }
}