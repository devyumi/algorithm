package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            String string = br.readLine();
            StringBuilder palindrome = new StringBuilder(string);
            int answer = 2;

            if (string.equals(palindrome.reverse().toString())) {
                answer = 0;
            } else {
                int start = 0;
                int end = string.length() - 1;

                while (start < end) {
                    if (string.charAt(start) != string.charAt(end)) {
                        StringBuilder left = new StringBuilder(string).deleteCharAt(start);
                        StringBuilder right = new StringBuilder(string).deleteCharAt(end);

                        if (left.toString().equals(left.reverse().toString()) || right.toString().equals(right.reverse().toString())) {
                            answer = 1;
                        }
                        break;
                    }
                    start++;
                    end--;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}