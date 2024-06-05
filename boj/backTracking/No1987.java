package boj.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class No1987 {
    private static int r;
    private static int c;
    private static char[][] arr;
    private static int[] weight;
    private static int max;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        weight = new int[26];
        max = 1;

        for (int i = 0; i < r; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = tmp[j];
            }
        }
        weight[(int) arr[0][0] - 65] = 1;
        dfs(0, 0);
        bw.write(String.valueOf(max));
        bw.close();
    }

    private static void dfs(int x, int y) {
        int now = (int) arr[x][y] - 65;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && weight[(int) arr[nx][ny] - 65] == 0) {
                weight[(int) arr[nx][ny] - 65] = weight[now] + 1;
                max = Math.max(max, weight[(int) arr[nx][ny] - 65]);
                dfs(nx, ny);
                weight[(int) arr[nx][ny] - 65] = 0;
            }
        }
    }
}