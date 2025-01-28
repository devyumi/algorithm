package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4920 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int answer;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            arr = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = true;
                    backTracking(i, j, arr[i][j], 0);
                    visited[i][j] = false;
                }
            }
            sb.append(t++).append(". ").append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void backTracking(int x, int y, int sum, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            if (!visited[nx][ny]) {
                if (depth == 1) {
                    visited[nx][ny] = true;
                    sum += arr[nx][ny];
                    backTracking(x, y, sum, depth + 1);
                    sum -= arr[nx][ny];
                    visited[nx][ny] = false;
                }

                visited[nx][ny] = true;
                sum += arr[nx][ny];
                backTracking(nx, ny, sum, depth + 1);
                sum -= arr[nx][ny];
                visited[nx][ny] = false;
            }
        }
    }
}
