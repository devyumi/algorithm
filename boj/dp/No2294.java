package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class No2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] value = new int[n + 1];
        int[] dp = new int[k + 1];

        for (int i = 1; i < n + 1; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < k + 1; i++) {
            dp[i] = (int) 1e9;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = value[i]; j < k + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - value[i]] + 1);
            }
        }

        if (dp[k] >= (int) 1e9) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(dp[k]));
        }
        bw.close();
    }
}