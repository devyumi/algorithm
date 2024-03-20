package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7562 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static Point arrival;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < t; k++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point now = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            arrival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs(now.x, now.y);
            sb.append(arr[arrival.x][arrival.y]).append("\n");
        }
        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.close();
    }

    private static void bfs(int x, int y) {
        int[] dx = {-2, -2, -1, -1, 2, 2, 1, 1};
        int[] dy = {1, -1, 2, -2, -1, 1, -2, 2};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == arrival.x && now.y == arrival.y) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    if (!visited[nextX][nextY]) {
                        arr[nextX][nextY] = arr[now.x][now.y] + 1;
                        queue.offer(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
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