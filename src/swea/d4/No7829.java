package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int p = Integer.parseInt(br.readLine());

            if (p == 1) {
                int tmp = Integer.parseInt(br.readLine());
                sb.append(tmp * tmp + "\n");
            } else {
                int max = -1;
                int min = (int) 1e9;

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < p; i++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    max = Math.max(max, tmp);
                    min = Math.min(min, tmp);
                }
                sb.append(max * min + "\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}