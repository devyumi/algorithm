package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            sb.append(calculateDay(m, d) + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int calculateDay(int m, int d) {
        int day = d;
        switch (m) {
            case 2:
                day += 31;
                break;
            case 3:
                day += 31 + 29;
                break;
            case 4:
                day += 31 + 29 + 31;
                break;
            case 5:
                day += 31 + 29 + 31 + 30;
                break;
            case 6:
                day += 31 + 29 + 31 + 30 + 31;
                break;
            case 7:
                day += 31 + 29 + 31 + 30 + 31 + 30;
                break;
            case 8:
                day += 31 + 29 + 31 + 30 + 31 + 30 + 31;
                break;
            case 9:
                day += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31;
                break;
            case 10:
                day += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                break;
            case 11:
                day += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                break;
            case 12:
                day += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                break;
        }
        return ((day % 7) + 3) % 7;
    }
}