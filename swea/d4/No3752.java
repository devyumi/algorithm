package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int sum = 0;
            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                for (int j = sum; j >= 0; j--) {
                    if (arr[i] + j <= sum && dp[j]) {
                        dp[arr[i] + j] = true;
                    }
                }
            }

            for (boolean b : dp) {
                if (b) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}