package boj.greedy;

import java.io.*;
import java.util.PriorityQueue;

public class No1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            pQ.offer(Integer.parseInt(br.readLine()));
        }

        while (pQ.size() != 1) {
            int sum = pQ.poll() + pQ.poll();
            answer += sum;
            pQ.offer(sum);
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}