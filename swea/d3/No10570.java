package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
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
                if (palindrome(String.valueOf(i))) {
                    if (Math.sqrt(i) == Math.floor(Math.sqrt(i))) {
                        if (palindrome(String.valueOf((int) Math.sqrt(i)))) {
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

    private static boolean palindrome(String n) {
        char[] chars = n.toCharArray();
        Deque<Character> deque = new LinkedList<>();

        for (char c : chars) {
            deque.offer(c);
        }

        while (deque.size() > 1) {
            char first = deque.peekFirst();
            char end = deque.peekLast();

            if (first == end) {
                deque.pollFirst();
                deque.pollLast();
            } else {
                return false;
            }
        }
        return true;
    }
}