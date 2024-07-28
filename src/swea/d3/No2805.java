package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                String[] tmp = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(tmp[j]);
                }
            }

            int start = n / 2;
            int count = 1;
            for (int i = 0; i <= n / 2; i++) {
                int k = start--;
                for (int j = 0; j < count; j++) {
                    sum += arr[i][k];
                    k++;
                }
                count += 2;
            }

            start = 1;
            count = n - 2;
            for (int i = n / 2 + 1; i < n; i++) {
                int k = start++;
                for (int j = 0; j < count; j++) {
                    sum += arr[i][k];
                    k++;
                }
                count -= 2;
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}