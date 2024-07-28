package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17319 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            sb.append(isString(n, str));
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static String isString(int n, String str) {
        if (n % 2 != 0) {
            return "No\n";
        } else {
            String sub = "";
            for (int i = 0; i < str.length() / 2; i++) {
                sub += str.charAt(i);
            }
            str = str.substring(str.length() / 2, str.length());
            if (sub.equals(str)) {
                return "Yes\n";
            } else {
                return "No\n";
            }
        }
    }
}