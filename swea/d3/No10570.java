package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int answer = 0;

            for (int i = a; i <= b; i++) {
                if (isPalindrome(String.valueOf(i))) {
                    if (Math.sqrt(i) == Math.floor(Math.sqrt(i))) {
                        if (isPalindrome(String.valueOf((int) Math.sqrt(i)))) {
                            answer++;
                        }
                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static boolean isPalindrome(String n) {
        char[] chars = n.toCharArray();
        int end = chars.length - 1;

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[end]) {
                return false;
            }
            end--;
        }
        return true;
    }
}