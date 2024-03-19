package boj.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class No11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000002];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (arr[h + 1] != 0) {
                arr[h + 1] -= 1;
            }
            arr[h] += 1;
        }

        for (int i : arr) {
            answer += i;
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}