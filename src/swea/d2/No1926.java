package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            if (String.valueOf(i).contains("3") || String.valueOf(i).contains("6") || String.valueOf(i).contains("9")) {
                sb.append(checkClap(i) + " ");
            } else {
                sb.append(i + " ");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static String checkClap(int n) {
        StringBuilder clap = new StringBuilder();
        char[] clapChar = String.valueOf(n).toCharArray();
        int count = 0;
        for (char c : clapChar) {
            if (c == '3' || c == '6' || c == '9') {
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            clap.append("-");
        }
        return clap.toString();
    }
}