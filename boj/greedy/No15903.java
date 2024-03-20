package boj.greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Long> pQ = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pQ.offer((long) Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long tmp = pQ.poll() + pQ.poll();
            pQ.offer(tmp);
            pQ.offer(tmp);
        }

        while (!pQ.isEmpty()) {
            answer += pQ.poll();
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}