package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            char[] strings = br.readLine().toCharArray();
            StringBuilder answer = new StringBuilder();

            for (char c : strings) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    continue;
                }
                answer.append(c);
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}