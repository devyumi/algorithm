package boj.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class No14503 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static int d;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c);
        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static void clean(int r, int c) {
        if (arr[r][c] == 0) {
            arr[r][c] = 2;
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            turnLeft();
            int nx = r + dx[d];
            int ny = c + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (arr[nx][ny] == 0) {
                    clean(nx, ny);
                    return;
                }
            }
        }
        int bx = reverseX(r);
        int by = reverseY(c);
        if (bx >= 0 && bx < n && by >= 0 && by < m) {
            if (arr[bx][by] != 1) {
                clean(bx, by);
            }
        }
    }

    private static void turnLeft() {
        if (d == 0) {
            d = 3;
        } else {
            d--;
        }
    }

    private static int reverseX(int r) {
        int bx = r;
        if (d == 0) {
            bx += dx[2];
        } else if (d == 1) {
            bx += dx[3];
        } else if (d == 2) {
            bx += dx[0];
        } else {
            bx += dx[1];
        }
        return bx;
    }

    private static int reverseY(int c) {
        int by = c;
        if (d == 0) {
            by += dy[2];
        } else if (d == 1) {
            by += dy[3];
        } else if (d == 2) {
            by += dy[0];
        } else {
            by += dy[1];
        }
        return by;
    }
}