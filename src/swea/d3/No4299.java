package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int time = (11 * 24 + 11) * 60 + 11;

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int realization = (d * 24 + h) * 60 + m;
            int answer = realization - time;

            if (answer >= 0) {
                sb.append(answer + "\n");
            } else {
                sb.append("-1\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}