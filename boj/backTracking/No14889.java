package boj.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class No14889 {
    private static int n;
    private static int[][] arr;
    private static boolean[] visited;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        min = (int) 1e9;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0, 0);
        bw.write(String.valueOf(min));
        bw.close();
    }

    private static void backTracking(int start, int depth) {
        if (depth == n / 2) {
            int startPower = 0;
            int linkPower = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        startPower += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        linkPower += arr[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(startPower - linkPower));
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}