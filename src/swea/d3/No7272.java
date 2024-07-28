package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7272 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        String zero = "CEFGHIJKLMNSTUVWXYZ";
        String one = "ADOPQR";
        String two = "B";

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] c1 = st.nextToken().toCharArray();
            char[] c2 = st.nextToken().toCharArray();
            boolean result = true;

            for (int i = 0; i < c1.length; i++) {
                if (c1.length != c2.length) {
                    result = false;
                    break;
                }

                if (zero.contains(String.valueOf(c1[i])) && !zero.contains(String.valueOf(c2[i]))) {
                    result = false;
                    break;
                } else if (one.contains(String.valueOf(c1[i])) && !one.contains(String.valueOf(c2[i]))) {
                    result = false;
                    break;
                } else if (two.contains(String.valueOf(c1[i])) && !two.contains(String.valueOf(c2[i]))) {
                    result = false;
                    break;
                }
            }

            if (result) {
                sb.append("SAME");
            } else {
                sb.append("DIFF");
            }
            sb.append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}