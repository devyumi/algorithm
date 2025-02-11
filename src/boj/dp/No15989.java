package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        int plus = 2;
        StringBuilder answer = new StringBuilder();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < 10001; i++) {
            //두 단계마다 plus + 1이 된다.
            if (i % 2 == 0) {
                plus++;
            }

            //1 2 3 4 5 7 8 10 ...
            dp[i] = dp[i - 3] + plus;
        }

        for (int i = 0; i < n; i++) {
            answer.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }
}
