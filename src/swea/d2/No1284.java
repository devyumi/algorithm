package swea.d2;

import java.io.*;
import java.util.StringTokenizer;

public class No1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int a = p * w;
            int b;

            if (w <= r) {
                b = q;
            } else {
                b = q + (w - r) * s;
            }

            sb.append(Math.min(a, b));
            if (k != t) {
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}