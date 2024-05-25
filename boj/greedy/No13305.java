package boj.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class No13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n - 1];
        int[] gas = new int[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }

        int min = gas[0];
        long sum = (long) min * distance[0];

        for (int i = 1; i < n - 1; i++) {
            if (min > gas[i]) {
                min = gas[i];
            }
            sum += (long) min * distance[i];
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}