package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append("\n");
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String str = st.nextToken();
                arr[i] = stringToInteger(str);
            }

            Arrays.sort(arr);
            for (int i : arr) {
                sb.append(intToString(i)).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int stringToInteger(String str) {
        int answer = 0;
        switch (str) {
            case "ONE":
                answer = 1;
                break;
            case "TWO":
                answer = 2;
                break;
            case "THR":
                answer = 3;
                break;
            case "FOR":
                answer = 4;
                break;
            case "FIV":
                answer = 5;
                break;
            case "SIX":
                answer = 6;
                break;
            case "SVN":
                answer = 7;
                break;
            case "EGT":
                answer = 8;
                break;
            case "NIN":
                answer = 9;
                break;
        }
        return answer;
    }

    private static String intToString(int a) {
        String str = "ZRO";
        switch (a) {
            case 1:
                str = "ONE";
                break;
            case 2:
                str = "TWO";
                break;
            case 3:
                str = "THR";
                break;
            case 4:
                str = "FOR";
                break;
            case 5:
                str = "FIV";
                break;
            case 6:
                str = "SIX";
                break;
            case 7:
                str = "SVN";
                break;
            case 8:
                str = "EGT";
                break;
            case 9:
                str = "NIN";
                break;
        }
        return str;
    }
}