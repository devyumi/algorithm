package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            char[] memory = br.readLine().toCharArray();
            int answer = 0;
            if (memory[0] == '1') {
                answer++;
            }

            for (int i = 0; i < memory.length - 1; i++) {
                if (memory[i] != memory[i + 1]) {
                    answer++;
                }
            }
            sb.append(answer);
            if (k != t) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}