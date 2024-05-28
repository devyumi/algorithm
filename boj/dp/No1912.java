package boj.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + tmp, tmp);
        }
        bw.write(String.valueOf(Arrays.stream(dp).max().getAsInt()));
        bw.close();
    }
}