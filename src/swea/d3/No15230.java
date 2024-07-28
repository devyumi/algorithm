package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            int answer = 0;
            char[] testcase = br.readLine().toCharArray();

            for (int i = 0; i < testcase.length; i++) {
                if (alphabet[i] == testcase[i]) {
                    answer++;
                } else {
                    break;
                }
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}