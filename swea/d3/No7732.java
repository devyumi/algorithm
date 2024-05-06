package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7732 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine(), ":");
            int nH = Integer.parseInt(st.nextToken());
            int nM = Integer.parseInt(st.nextToken());
            int nS = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), ":");
            int pH = Integer.parseInt(st.nextToken());
            int pM = Integer.parseInt(st.nextToken());
            int pS = Integer.parseInt(st.nextToken());

            if (pS >= nS) {
                pS -= nS;
            } else {
                pS += 60 - nS;
                pM -= 1;
            }

            if (pM >= nM) {
                pM -= nM;
            } else {
                pM += 60 - nM;
                pH -= 1;
            }

            if (pH >= nH) {
                pH -= nH;
            } else {
                pH += 24 - nH;
            }
            sb.append(makeTime(pH) + ":" + makeTime(pM) + ":" + makeTime(pS) + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static String makeTime(int time) {
        if (time < 10) {
            return "0" + time;
        } else {
            return time + "";
        }
    }
}