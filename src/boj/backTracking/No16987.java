package boj.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class No16987 {
    private static int n;
    private static int[][] arr;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        backTracking(0);
        bw.write(String.valueOf(max));
        bw.close();
    }

    private static void backTracking(int depth) {
        if (depth == n) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i][0] <= 0) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i][0] > 0 && arr[depth][0] > 0) {
                if (i != depth) {
                    arr[i][0] -= arr[depth][1];
                    arr[depth][0] -= arr[i][1];
                    backTracking(depth + 1);
                    arr[i][0] += arr[depth][1];
                    arr[depth][0] += arr[i][1];
                }
            } else {
                backTracking(depth + 1);
            }
        }
    }
}