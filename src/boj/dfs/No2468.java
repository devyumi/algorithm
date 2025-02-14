package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2468 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int h = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                h = Math.max(h, arr[i][j]);
            }
        }

        //높이 0 ~ 최대까지 확인
        for (int k = 0; k <= h; k++) {
            visited = new boolean[n][n];
            int result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ( arr[i][j] > k && !visited[i][j]) {
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
        System.out.print(answer);
        br.close();
    }

    private static void dfs(int x, int y, int high) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || arr[nx][ny] <= high) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, high);
        }
    }
}