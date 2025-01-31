package boj.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + 1;
        int m = Integer.parseInt(br.readLine());
        int[][] distance = new int[n][n];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j < n; j++) {
                int node = Integer.parseInt(st.nextToken());
                if (node == 1) {
                    distance[i][j] = 1;
                    distance[j][i] = 1;
                } else if (node == 0 && i != j) {
                    distance[i][j] = (int) 1e9;
                }
            }
        }
        floyd(distance, n);

        String[] plan = br.readLine().split(" ");
        System.out.print(checkPlan(plan, distance));
        br.close();
    }

    private static void floyd(int[][] distance, int n) {
        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    private static String checkPlan(String[] plan, int[][] distance) {
        for (int i = 0; i < plan.length - 1; i++) {
            int start = Integer.parseInt(plan[i]);
            int end = Integer.parseInt(plan[i + 1]);

            if (distance[start][end] == (int) 1e9) {
                return "NO";
            }
        }
        return "YES";
    }
}
