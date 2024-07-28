package boj.bfs;

import java.io.*;
import java.util.StringTokenizer;

public class No2468 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int high = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                high = Math.max(high, arr[i][j]);
            }
        }

        for (int k = 0; k <= high; k++) {
            visited = new boolean[n][n];
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > k && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j, k);
                        result++;
                    }
                }
            }
            if (result == 0) {
                break;
            }
            answer = Math.max(answer, result);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static void dfs(int x, int y, int high) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] > high && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, high);
            }
        }
    }
}