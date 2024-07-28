package boj.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No2583 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static ArrayList<Integer> list;
    private static int tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        list = new ArrayList<>();
        int answer = 0;

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int j2 = Integer.parseInt(st.nextToken());

            for (int i = i1; i < i2; i++) {
                for (int j = j1; j < j2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    tmp = 0;
                    answer += dfs(i, j);
                    list.add(tmp);
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(answer + "\n");
        for (int i : list) {
            sb.append(i).append(" ");
        }

        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.close();
    }

    private static int dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return 0;
        }

        if (arr[x][y] == 0) {
            arr[x][y] = 1;
            tmp++;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }
        return 1;
    }
}