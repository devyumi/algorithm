package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7576 {
    private static int n;
    private static int m;
    private static Tomato[][] arr;
    private static boolean[][] visited;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new Tomato[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                arr[i][j] = new Tomato(tomato, 0);
                if (arr[i][j].state == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        if (!isZero(arr)) {
            bw.write("0");
        } else {
            bfs(arr);
            if (isZero(arr)) {
                bw.write("-1");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        maxDay = Math.max(maxDay, arr[i][j].day);
                    }
                }
                bw.write(String.valueOf(maxDay));
            }
        }
        bw.close();
    }

    private static boolean isZero(Tomato[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].state == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void bfs(Tomato[][] arr) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            visited[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny].state == 0 && !visited[nx][ny]) {
                        arr[nx][ny].state = 1;
                        arr[nx][ny].day += arr[now.x][now.y].day + 1;
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private static class Tomato {
        int state;
        int day;

        public Tomato(int state, int day) {
            this.state = state;
            this.day = day;
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}