package boj;

import java.io.*;

//dp
public class No2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[0];
        if (n >= 2) {
            dp[2] = stairs[0] + stairs[1];
            for (int i = 3; i < n + 1; i++) {
                dp[i] = Math.max(dp[i - 3] + stairs[i - 2] + stairs[i - 1], dp[i - 2] + stairs[i - 1]);
            }
        }
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}