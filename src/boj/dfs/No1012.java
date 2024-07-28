package boj.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class No1012 {
    private static int m;
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int l = 0; l < t; l++) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result += dfs(i, j);
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
    }

    private static int dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }

        if (arr[x][y] == 1) {
            arr[x][y] = 0;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return 1;
        }
        return 0;
    }
}