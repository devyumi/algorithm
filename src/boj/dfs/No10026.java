package boj.dfs;

import java.io.*;

public class No10026 {
    private static int n;
    private static char[][] arr;
    private static boolean[][] visited1;
    private static boolean[][] visited2;
    private static int result1 = 0;
    private static int result2 = 0;
    private static char tmp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = strings[j].charAt(0);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    tmp = arr[i][j];
                    result1 += dfs1(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited2[i][j]) {
                    tmp = arr[i][j];
                    result2 += dfs2(i, j);
                }
            }
        }

        bw.write(result1 + " " + result2);
        bw.close();
    }

    private static int dfs1(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }

        if (!visited1[x][y]) {
            if (arr[x][y] == tmp) {
                visited1[x][y] = true;
                dfs1(x - 1, y);
                dfs1(x + 1, y);
                dfs1(x, y - 1);
                dfs1(x, y + 1);
                return 1;
            }
        }
        return 0;
    }

    private static int dfs2(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }

        if (!visited2[x][y]) {
            if (tmp == 'R' || tmp == 'G') {
                if (arr[x][y] == 'R' || arr[x][y] == 'G') {
                    visited2[x][y] = true;
                    dfs2(x - 1, y);
                    dfs2(x + 1, y);
                    dfs2(x, y - 1);
                    dfs2(x, y + 1);
                    return 1;
                }
            } else if (tmp == 'B') {
                if (arr[x][y] == 'B') {
                    visited2[x][y] = true;
                    dfs2(x - 1, y);
                    dfs2(x + 1, y);
                    dfs2(x, y - 1);
                    dfs2(x, y + 1);
                    return 1;
                }
            }
        }
        return 0;
    }
}