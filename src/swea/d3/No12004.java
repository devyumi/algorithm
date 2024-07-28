package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No12004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());

            if (multiply(n)) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static boolean multiply(int n) {
        for (int i = 1; i <= 9; i++) {
            if (n % i == 0) {
                if (n / i <= 9) {
                    return true;
                }
            }
        }
        return false;
    }
}