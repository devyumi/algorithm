package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);

        while (!queue.isEmpty()) {
            String next = queue.poll();

            //queue에서 꺼낸 문자와 t가 같으면 프로그램 종료
            if (next.equals(t)) {
                answer = 1;
                break;
            }

            if (next.length() < t.length()) {
                //1) 문자열 뒤에 A 추가
                StringBuilder sb = new StringBuilder(next);
                sb.append("A");
                queue.offer(sb.toString());

                //2) 문자열 뒤집고 뒤에 B 추가
                sb = new StringBuilder(next);
                sb.reverse().append("B");
                queue.offer(sb.toString());
            }
        }
        System.out.print(answer);
    }
}
