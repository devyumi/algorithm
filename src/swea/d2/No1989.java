package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class No1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            char[] tmp = br.readLine().toCharArray();
            Deque deque = new LinkedList();

            for (char c : tmp) {
                deque.offer(c);
            }

            boolean answer = palindrome(deque);

            if (answer) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            if (k != t) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private static boolean palindrome(Deque deque) {
        while (deque.size() > 1) {
            char first = (char) deque.peekFirst();
            char end = (char) deque.peekLast();

            if (first != end) {
                return false;
            } else {
                deque.pollFirst();
                deque.pollLast();
            }
        }
        return true;
    }
}
