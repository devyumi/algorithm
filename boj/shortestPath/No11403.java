package boj.shortestPath;

import java.io.*;
import java.util.StringTokenizer;

public class No11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 0) {
                    graph[i][j] = (int) 1e9;
                }
            }
        }

        floyd(graph);
        bw.write(printGraph(graph));
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

    private static String printGraph(int[][] graph) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == (int) 1e9) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}