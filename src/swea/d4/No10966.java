package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No10966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] arr = new char[n][m];
            boolean[][] visited = new boolean[n][m];
            Queue<Point> queue = new LinkedList<>();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int sum = 0;

            for (int i = 0; i < n; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = tmp[j];
                    if (arr[i][j] == 'W') {
                        queue.offer(new Point(i, j, 0));
                        visited[i][j] = true;
                    }
                }
            }

            while (!queue.isEmpty()) {
                Point now = queue.poll();
                sum += now.count;

                for (int i = 0; i < 4; i++) {
                    Point next = new Point(now.x + dx[i], now.y + dy[i], now.count + 1);

                    if (next.x >= 0 && next.x < n && next.y >= 0 && next.y < m && !visited[next.x][next.y]) {
                        queue.offer(next);
                        visited[next.x][next.y] = true;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static class Point {
        private int x;
        private int y;
        private int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}