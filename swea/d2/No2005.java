package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int[][] dp = new int[10][10];
        dp[0][0] = 1;

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        for (int t = 1; t <= tc; t++) {
            System.out.println("#" + t);
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == i + 1) {
                        break;
                    }
                    System.out.print(dp[i][j]);
                    if (j != i) {
                        System.out.print(" ");
                    }
                }
                if (i != n - 1) {
                    System.out.println();
                }
            }
            if (t != tc) {
                System.out.println();
            }
        }
        br.close();
    }
}