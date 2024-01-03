package ndb;

import java.io.*;
import java.util.*;

public class No103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];
        List<Road> graph = new ArrayList<>();
        int result = 0;
        int max = 0;

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.add(new Road(v, e, w));
        }

        Collections.sort(graph, (o1, o2) -> o1.weight - o2.weight);
        for (Road road : graph) {
            if (find(parent, road.start) != find(parent, road.end)) {
                union(parent, road.start, road.end);
                max = road.weight;
                result += max;
            }
        }
        bw.write(String.valueOf(result - max));
        bw.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int a = find(parent, x);
        int b = find(parent, y);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static class Road {
        private int start;
        private int end;
        private int weight;

        public Road(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}