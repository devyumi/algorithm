package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11856 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            int[] arr = new int[26];
            char[] string = br.readLine().toCharArray();

            for (char c : string) {
                arr[(int) c - 65]++;
            }

            if (isTwo(arr)) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static boolean isTwo(int[] arr) {
        int answer = 0;

        for (int i : arr) {
            if (i == 1) {
                return false;
            } else if (i > 2) {
                return false;
            } else {
                answer += i;
            }
        }
        if (answer > 4) {
            return false;
        } else {
            return true;
        }
    }
}