package ndb;

import java.io.*;
import java.util.StringTokenizer;

//dfs
public class No53_2 {
    private static int n;
    private static int m;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(token[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j) == 1) {
                    result++;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

    private static int dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return -1;
        }

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return 1;
        }
        return -1;
    }
}