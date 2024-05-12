package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No16800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            long n = Long.parseLong(br.readLine());
            long answer = Long.MAX_VALUE;

            for (long i = 1; i < n; i++) {
                if (n / i < i) {
                    break;
                }
                if (n % i == 0) {
                    answer = Math.min(answer, n / i + i);
                }
            }
            sb.append(answer - 2).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}