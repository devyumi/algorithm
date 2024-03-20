package boj.shortestPath;

import java.io.*;
import java.util.StringTokenizer;

public class No1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] distance = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                distance[i][j] = (int) 1e9;
                if (i == j) {
                    distance[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = c;
        }

        floyd(distance);
        bw.write(String.valueOf(getMaxTime(distance, x)));
        bw.close();
    }

    private static void floyd(int[][] distance) {
        for (int k = 1; k < distance.length; k++) {
            for (int i = 1; i < distance.length; i++) {
                for (int j = 1; j < distance.length; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    private static int getMaxTime(int[][] distance, int x) {
        int max = -1;

        for (int i = 1; i < distance.length; i++) {
            int dis = distance[i][x] + distance[x][i];
            max = Math.max(max, dis);
        }
        return max;
    }
}