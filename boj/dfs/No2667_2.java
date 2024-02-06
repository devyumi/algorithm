package boj.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class No2667_2 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        home = 0;
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
                    home = dfs(i, j);
                    homeCount.add(home);
                    result++;
                    home = 0;
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
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }

        if (arr[x][y] == 1) {
            arr[x][y] = 0;
            visited[x][y] = true;
            home++;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return home;
        }
        return 0;
    }
}