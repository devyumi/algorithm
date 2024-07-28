package ndb;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q43 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n];
        ArrayList<Road> graph = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.add(new Road(x, y, weight));
        }

        Collections.sort(graph, (o1, o2) -> o1.weight - o2.weight);
        for (Road r : graph) {
            int x = find(parent, r.x);
            int y = find(parent, r.y);
            if (x != y) {
                union(parent, x, y);
            } else {
                result += r.weight;
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int pX = find(parent, x);
        int pY = find(parent, y);
        if (pX < pY) {
            parent[pY] = pX;
        } else {
            parent[pX] = pY;
        }
    }

    private static class Road {
        private int x, y, weight;

        public Road(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
