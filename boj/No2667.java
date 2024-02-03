package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class No2667 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        int result = 0;
        ArrayList<Integer> homeCount = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    homeCount.add(dfs(i, j));
                    result++;
                }
            }
        }

        Collections.sort(homeCount);
        bw.write(result + "\n");
        for (int i : homeCount) {
            bw.write(i + "\n");
        }
        bw.close();
    }

    private static int dfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int homeCount = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        arr[x][y] = 0;
        visited[x][y] = true;
        homeCount++;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                        homeCount++;
                    }
                }
            }
        }
        return homeCount;
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