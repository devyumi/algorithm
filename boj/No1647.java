package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No1647 {
    private static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge> graph = new ArrayList<>();
        int[] parent = new int[n + 1];
        result = new ArrayList<>();
        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a, b, w));
        }

        kruskal(graph, parent);
        for (int i = 0; i < result.size() - 1; i++) {
            answer += result.get(i);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static void kruskal(ArrayList<Edge> graph, int[] parent) {
        Collections.sort(graph, Comparator.comparingInt(o -> o.weight));

        for (Edge edge : graph) {
            if (find(parent, edge.x) != find(parent, edge.y)) {
                union(parent, edge.x, edge.y);
                result.add(edge.weight);
            }
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int x1 = find(parent, x);
        int y1 = find(parent, y);

        if (x1 < y1) {
            parent[y1] = x1;
        } else {
            parent[x1] = y1;
        }
    }

    private static class Edge {
        private int x;
        private int y;
        private int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}