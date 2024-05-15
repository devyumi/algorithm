package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1948 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int month1 = Integer.parseInt(st.nextToken());
            int day1 = Integer.parseInt(st.nextToken());
            int month2 = Integer.parseInt(st.nextToken());
            int day2 = Integer.parseInt(st.nextToken());

            if (month1 == month2) {
                sb.append(day2 - day1 + 1).append("\n");
            } else {
                sb.append(calDay(month2, day2) - calDay(month1, day1) + 1).append("\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int calDay(int month, int day) {
        int sum = 0;
        switch (month) {
            case 2:
                sum += 31;
                break;

            case 3:
                sum += 31 + 28;
                break;

            case 4:
                sum += 31 + 28 + 31;
                break;

            case 5:
                sum += 31 + 28 + 31 + 30;
                break;

            case 6:
                sum += 31 + 28 + 31 + 30 + 31;
                break;

            case 7:
                sum += 31 + 28 + 31 + 30 + 31 + 30;
                break;

            case 8:
                sum += 31 + 28 + 31 + 30 + 31 + 30 + 31;
                break;

            case 9:
                sum += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
                break;

            case 10:
                sum += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                break;

            case 11:
                sum += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                break;

            case 12:
                sum += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                break;
        }
        return sum + day;
    }
}