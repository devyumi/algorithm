package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//플로이드워셜, 2차원 배열
public class No11404 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(graph[a][b] > c){
                graph[a][b] = c;
            }
        }

        floyd(graph);
        printGraph(graph);
    }

    private static void floyd(int[][] graph){
        for (int k = 1; k < graph.length; k++) {
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph.length; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    private static void printGraph(int[][] graph){
        for(int i = 1; i < graph.length; i++){
            for(int j = 1 ;j<graph[i].length;j++){
                if(graph[i][j] == INF){
                    System.out.print("0 ");
                }
                else{
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}