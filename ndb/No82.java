package ndb;

import java.io.*;

//dp
public class No82 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i]);
            }
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i / 5], dp[i]);
            }
            dp[i]++;
        }
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}
