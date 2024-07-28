package boj.dp;

import java.io.*;

public class No5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] string1 = br.readLine().toCharArray();
        char[] string2 = br.readLine().toCharArray();
        int[][] dp = new int[string1.length + 1][string2.length + 1];
        int answer = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (string1[i - 1] == string2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}