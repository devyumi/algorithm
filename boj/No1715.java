package boj;

import java.io.*;
import java.util.PriorityQueue;

// 우선순위 큐
public class No1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> o1.intValue() - o2.intValue());
        for (int i = 0; i < n; i++) {
            pQ.offer(Integer.parseInt(br.readLine()));
        }

        while (pQ.size() != 1) {
            int sum = pQ.poll() + pQ.poll();
            result += sum;
            pQ.offer(sum);
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}