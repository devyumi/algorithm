package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 1;
        int[] oil = new int[n];
        int[] distance = new int[n];
        long answer = 0;
        int min = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        answer = (long) oil[0] * distance[0];
        min = oil[0];
        for (int i = 1; i < n; i++) {
            if (min > oil[i]) {
                min = oil[i];
            }
            answer += (long) min * distance[i];
        }
        System.out.print(answer);
        br.close();
    }
}