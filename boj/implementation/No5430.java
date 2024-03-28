package boj.implementation;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class No5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < t; k++) {
            String function = br.readLine();
            br.readLine();

            String str = br.readLine();
            Deque<String> deque = new LinkedList<>();
            for (String s : str.substring(1, str.length() - 1).split(",")) {
                if (!s.equals("")) {
                    deque.offer(s);
                }
            }

            sb.append(AC(deque, function)).append("\n");
        }
        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.close();
    }

    private static String AC(Deque<String> deque, String function) {
        boolean isReverse = false;

        for (char ac : function.toCharArray()) {
            if (ac == 'R') {
                isReverse = !isReverse;
            } else {
                if (deque.size() == 0) {
                    return "error";
                }

                if (isReverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder("[");

        while (!deque.isEmpty()) {
            if (isReverse) {
                sb.append(deque.pollLast());
            } else {
                sb.append(deque.pollFirst());
            }
            if (deque.size() != 0) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}