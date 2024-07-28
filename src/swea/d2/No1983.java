package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1983 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Double[] arr = new Double[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                double sum = Double.parseDouble(st.nextToken()) * 0.35 + Double.parseDouble(st.nextToken()) * 0.45 + Double.parseDouble(st.nextToken()) * 0.2;
                arr[i] = sum;
            }

            double scoreOfK = arr[k - 1];
            Arrays.sort(arr, Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                if (arr[i] == scoreOfK) {
                    sb.append("#").append(t).append(" ").append(rank(i + 1, n)).append("\n");
                }
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static String rank(int score, int all) {
        int quotient = all / 10;
        int rank = 1;
        String ranks = "";

        while (quotient < score) {
            rank++;
            quotient += all / 10;

        }

        switch (rank) {
            case 1:
                ranks = "A+";
                break;
            case 2:
                ranks = "A0";
                break;
            case 3:
                ranks = "A-";
                break;
            case 4:
                ranks = "B+";
                break;
            case 5:
                ranks = "B0";
                break;
            case 6:
                ranks = "B-";
                break;
            case 7:
                ranks = "C+";
                break;
            case 8:
                ranks = "C0";
                break;
            case 9:
                ranks = "C-";
                break;
            case 10:
                ranks = "D0";
                break;
        }
        return ranks;
    }
}