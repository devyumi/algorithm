package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n + 1][l + 1];
            int[] value = new int[n + 1];
            int[] weight = new int[n + 1];

            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                value[i] = Integer.parseInt(st.nextToken());
                weight[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < l + 1; j++) {
                    if (weight[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                    }
                }
            }
            sb.append(dp[n][l] + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}