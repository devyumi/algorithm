package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7569 {
    private static int m;
    private static int n;
    private static int h;
    private static int[][][] arr;
    private static Queue<Point> queue;
    private static final int[] dx = {0, 0, -1, 1, 0, 0};
    private static final int[] dy = {0, 0, 0, 0, -1, 1};
    private static final int[] dz = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[n][m][h];
        queue = new LinkedList<>();
        boolean isRipen = true;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 0 && isRipen) {
                        isRipen = false;
                    }

                    if (arr[i][j][k] == 1) {
                        queue.offer(new Point(i, j, k));
                    }
                }
            }
        }

        if (isRipen) {
            bw.write("0");
        } else {
            bfs();
            bw.write(String.valueOf(calculateDay()));
        }
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && arr[nx][ny][nz] == 0) {
                    arr[nx][ny][nz] = arr[now.x][now.y][now.z] + 1;
                    queue.offer(new Point(nx, ny, nz));
                }
            }
        }
    }

    private static int calculateDay() {
        int max = -1;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    } else {
                        max = Math.max(max, arr[i][j][k]);
                    }
                }
            }
        }
        return max - 1;
    }

    private static class Point {
        private int x;
        private int y;
        private int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}