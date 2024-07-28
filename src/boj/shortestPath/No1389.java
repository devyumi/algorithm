package boj.shortestPath;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], (int) 1e9);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a - 1][b - 1] = 1;
            graph[b - 1][a - 1] = 1;
        }

        floyd(graph);
        bw.write(String.valueOf(findMinBacon(graph)));
        bw.close();
    }

    private static void floyd(int[][] graph) {
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    private static int findMinBacon(int[][] graph) {
        int[] bacon = new int[graph.length];
        int minIndex = 0;
        for (int i = 0; i < graph.length; i++) {
            int sum = 0;
            for (int j = 0; j < graph.length; j++) {
                sum += graph[i][j];
            }
            bacon[i] = sum;
        }

        int minBacon = Arrays.stream(bacon).min().getAsInt();
        for (int i = 0; i < graph.length; i++) {
            if (bacon[i] == minBacon) {
                minIndex = i + 1;
                break;
            }
        }
        return minIndex;
    }
}
