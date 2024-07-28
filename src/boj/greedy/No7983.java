package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No7983 {
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

        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);

        int lastDay = arr[0][1];
        for (int i = 0; i < n; i++) {
            if (lastDay >= arr[i][1]) {
                lastDay = arr[i][1] - arr[i][0];
            } else {
                lastDay -= arr[i][0];
            }
        }

        bw.write(String.valueOf(lastDay));
        bw.close();
    }
}