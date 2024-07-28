package boj.implementation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2638 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            answer++;
            visited = new boolean[n][m];
            dfs(0, 0);
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                Point now = queue.poll();
                int cnt = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if (arr[nx][ny] == -1) {
                        cnt++;
                    }
                }

                if (cnt >= 2) {
                    arr[now.x][now.y] = 0;
                } else {
                    queue.offer(now);
                }
            }
        }
        System.out.print(answer);
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        arr[x][y] = -1;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] != 1) {
                dfs(nx, ny);
            }
        }
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}