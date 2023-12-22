package ndb;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//플로이드워셜, K를 거쳐 X로 간다.
public class No92 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        floyd(graph);
        int distance = graph[1][k] + graph[k][x];

        if (distance >= INF) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(distance));
        }
        bw.close();
    }

    private static void floyd(int[][] graph) {
        for (int k = 1; k < graph.length; k++) {
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph.length; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}
