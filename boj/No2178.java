package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
public class No2178 {
    static int n;
    static int m;
    static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];

        for (int i = 0; i < maze.length; i++) {
            String[] token = br.readLine().split("");
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = Integer.parseInt(token[j]);
            }
        }
        bw.write(String.valueOf(bfs(0, 0)));
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (maze[nx][ny] == 0) {
                    continue;
                }
                if (maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[now.x][now.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return maze[n - 1][m - 1];
    }

    private static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}