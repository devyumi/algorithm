package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            boolean[] fish = new boolean[11112];

            st = new StringTokenizer(br.readLine());
            int max = -1;
            for (int i = 0; i < n; i++) {
                int index = Integer.parseInt(st.nextToken());
                fish[index] = true;
                max = Math.max(max, index);
            }

            for (int i = 1; i <= max; i++) {
                if (i % m == 0) {
                    count += k;
                }

                if (fish[i]) {
                    if (count == 0 || fish[0]) {
                        count = -1;
                        break;
                    } else {
                        count -= 1;
                    }
                }
            }

            if (count == -1) {
                sb.append("Impossible\n");
            } else {
                sb.append("Possible\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}