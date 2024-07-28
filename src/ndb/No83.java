package ndb;

import java.io.*;
import java.util.StringTokenizer;

//dp
public class No83 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);
        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(arr[i - 1] + dp[i - 2], dp[i - 1]);
        }
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}
