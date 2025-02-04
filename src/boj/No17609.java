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
            String str = br.readLine();
            StringBuilder palindrome = new StringBuilder(str);
            int answer = 2;

            //팬린드롬 확인
            if (str.equals(palindrome.reverse())) {
                answer = 0;
            } else {
                int start = 0;
                int end = str.length() - 1;

                //두포인터 적용
                while (start < end) {
                    if (str.charAt(start) != str.charAt(end)) {
                        StringBuilder left = new StringBuilder(str).deleteCharAt(start);
                        StringBuilder right = new StringBuilder(str).deleteCharAt(end);

                        //한 문자 삭제
                        if (left.equals(left.reverse()) || right.equals(right.reverse())) {
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