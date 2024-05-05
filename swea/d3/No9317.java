package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            br.readLine();
            char[] string1 = br.readLine().toCharArray();
            char[] string2 = br.readLine().toCharArray();
            int answer = 0;

            for (int i = 0; i < string1.length; i++) {
                if (string1[i] == string2[i]) {
                    answer++;
                }
            }

            sb.append(answer + "\n");
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}