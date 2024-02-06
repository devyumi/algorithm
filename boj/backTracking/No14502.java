package boj.backTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14502 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static ArrayList<Point> safety;
    private static ArrayList<Point> virus;
    private static boolean[] visited;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        safety = new ArrayList<>();
        virus = new ArrayList<>();
        max = -(int) 1e9;

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    safety.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[safety.size()];
        backTracking(0, 0);
        bw.write(String.valueOf(max));
        bw.close();
    }

    private static void backTracking(int start, int depth) {
        if (depth == 3) {
            int result = 0;

            int[][] virusArr = new int[n + 1][m + 1];

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    virusArr[i][j] = arr[i][j];
                }
            }

            bfs(virusArr);

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    if (virusArr[i][j] == 0) {
                        result++;
                    }
                }
            }

            max = Math.max(max, result);
            return;
        }

        for (int i = start; i < safety.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                int x = safety.get(i).x;
                int y = safety.get(i).y;

                arr[x][y] = 1;
                backTracking(i + 1, depth + 1);
                visited[i] = false;
                arr[x][y] = 0;
            }
        }
    }

    private static void bfs(int[][] virusArr) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> queue = new LinkedList<>();
        for (Point p : virus) {
            queue.add(p);
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if (virusArr[nx][ny] == 0) {
                        virusArr[nx][ny] = 2;
                        queue.add(new Point(nx, ny));
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