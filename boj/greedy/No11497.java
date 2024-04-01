package boj.greedy;

import java.io.*;
import java.util.*;

public class No11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Collections.reverseOrder());
            Deque<Integer> deque = new LinkedList<>();
            deque.offer(arr[0]);

            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) {
                    deque.offerFirst(arr[i]);
                } else {
                    deque.offerLast(arr[i]);
                }
            }

            int max = Math.abs(deque.peekFirst() - deque.peekLast());
            while (deque.size() != 1) {
                max = Math.max(max, Math.abs(deque.pollFirst() - deque.peekFirst()));
            }
            sb.append(max).append("\n");
        }
        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.close();
    }
}