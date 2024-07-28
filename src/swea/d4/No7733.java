package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7733 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            int maxDay = 0;
            int answer = 0;
            day = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxDay = Math.max(maxDay, arr[i][j]);
                }
            }

            while (day < maxDay) {
                int count = 0;
                visited = new boolean[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] > day && !visited[i][j]) {
                            count += bfs(i, j);
                        }
                    }
                }
                answer = Math.max(answer, count);
                day++;
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);

                if (next.x >= 0 && next.x < n && next.y >= 0 && next.y < n) {
                    if (arr[next.x][next.y] > day && !visited[next.x][next.y]) {
                        queue.offer(next);
                        visited[next.x][next.y] = true;
                    }
                }
            }
        }
        return 1;
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