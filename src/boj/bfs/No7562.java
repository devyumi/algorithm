package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7562 {
    private static int i;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    private static Point to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            i = Integer.parseInt(br.readLine());
            arr = new int[i][i];
            visited = new boolean[i][i];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Point from = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            to = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            bfs(from.x, from.y);
            sb.append(arr[to.x][to.y]).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == to.x && now.y == to.y) {
                return;
            }

            for (int j = 0; j < 8; j++) {
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                if (nx >= 0 && nx < i && ny >= 0 && ny < i && !visited[nx][ny]) {
                    arr[nx][ny] = arr[now.x][now.y] + 1;
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
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