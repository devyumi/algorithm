package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.offer(arr[0][1]);

        for (int i = 1; i < n; i++) {
            if (pQ.peek() <= arr[i][0]) {
                pQ.poll();
            }
            pQ.offer(arr[i][1]);
        }

        bw.write(String.valueOf(pQ.size()));
        bw.close();
    }
}