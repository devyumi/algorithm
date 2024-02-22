package boj.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class No14889 {
    private static int n;
    private static int[][] arr;
    private static int[] start;
    private static int[] link;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        start = new int[n / 2];
        link = new int[n / 2];
        visited = new boolean[n + 1];
        result = Integer.MAX_VALUE;

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(1, 0);
        bw.write(String.valueOf(result));
        bw.close();
    }

    private static void backTracking(int starting, int depth) {
        if (depth == n / 2) {
            boolean[] visited2 = new boolean[n + 1];
            for (int i : start) {
                visited2[i] = true;
            }

            int j = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited2[i]) {
                    link[j] = i;
                    j++;
                }
            }

            calculatePower();
            return;
        }

        for (int i = starting; i < n + 1; i++) {
            if (!visited[i]) {
                start[depth] = i;
                visited[i] = true;
                backTracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculatePower() {
        int startPower = 0;
        int linkPower = 0;

        for (int i = 0; i < n / 2 - 1; i++) {
            for (int j = i + 1; j < n / 2; j++) {
                startPower += arr[start[i]][start[j]];
                startPower += arr[start[j]][start[i]];
                linkPower += arr[link[i]][link[j]];
                linkPower += arr[link[j]][link[i]];
            }
        }
        result = Math.min(result, Math.abs(startPower - linkPower));
    }
}