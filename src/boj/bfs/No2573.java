package boj.bfs;

import java.io.*;
import java.util.StringTokenizer;

public class No2573 {
    private static int[][] arr;
    private static int[][] weight;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        weight = new int[n][m];
        int year = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int count = 0;
            visited = new boolean[n][m];
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (arr[i][j] > 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if (count >= 2) {
                break;
            }

            if (count == 0) {
                year = 0;
                break;
            }

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (arr[i][j] > 0) {
                        bfs(i, j);
                    }
                }
            }
            year++;

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    arr[i][j] = weight[i][j];
                }
            }
        }
        bw.write(String.valueOf(year));
        bw.close();
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (arr[nx][ny] > 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    private static void bfs(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (arr[nx][ny] == 0) {
                count++;
            }
        }
        weight[x][y] = Math.max(arr[x][y] - count, 0);
    }
}
