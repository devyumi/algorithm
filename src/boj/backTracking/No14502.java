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
    private static ArrayList<Point> virus;
    private static ArrayList<Point> safety;
    private static boolean[] visitedList;
    private static boolean[][] visitedArr;
    private static int[][] virusArr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        virus = new ArrayList<>();
        safety = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    safety.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        visitedList = new boolean[safety.size()];
        backTracking(0, 0);
        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static void backTracking(int start, int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = start; i < safety.size(); i++) {
            if (!visitedList[i]) {
                visitedList[i] = true;
                arr[safety.get(i).x][safety.get(i).y] = 1;
                backTracking(i + 1, depth + 1);
                visitedList[i] = false;
                arr[safety.get(i).x][safety.get(i).y] = 0;
            }
        }
    }

    private static void bfs() {
        virusArr = new int[n][m];
        visitedArr = new boolean[n][m];
        int safetyMax = 0;
        Queue<Point> queue = new LinkedList<>();
        for (Point p : virus) {
            queue.offer(new Point(p.x, p.y));
            visitedArr[p.x][p.y] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusArr[i][j] = arr[i][j];
            }
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (virusArr[nx][ny] == 0 && !visitedArr[nx][ny]) {
                        virusArr[nx][ny] = 2;
                        visitedArr[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusArr[i][j] == 0) {
                    safetyMax++;
                }
            }
        }
        answer = Math.max(answer, safetyMax);
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