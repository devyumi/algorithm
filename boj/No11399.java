package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//정렬, dp(그리디)
public class No11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        int[] dp = new int[1001];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);
        dp[1] = time[0];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + time[i - 1];
        }

        for (int i = 1; i < n + 1; i++) {
            result += dp[i];
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}