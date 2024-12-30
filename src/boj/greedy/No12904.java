package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        while(s.length() < t.toString().length()) {
            //마지막 문자가 A면 삭제, B면 삭제 후 뒤집음
            if(t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        if (s.equals(t.toString())) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
