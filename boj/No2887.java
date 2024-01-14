package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Kruskal
public class No2887 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> point = new ArrayList<>();
        ArrayList<Road> graph = new ArrayList<>();
        int[] parent = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            point.add(new Point(i, x, y, z));
        }

        Collections.sort(point, (o1, o2) -> o1.x - o2.x);
        for (int i = 0; i < n - 1; i++) {
            long weight = Math.abs(point.get(i).x - point.get(i + 1).x);
            graph.add(new Road(point.get(i).i, point.get(i + 1).i, weight));
        }

        Collections.sort(point, (o1, o2) -> o1.y - o2.y);
        for (int i = 0; i < n - 1; i++) {
            long weight = Math.abs(point.get(i).y - point.get(i + 1).y);
            graph.add(new Road(point.get(i).i, point.get(i + 1).i, weight));
        }

        Collections.sort(point, (o1, o2) -> o1.z - o2.z);
        for (int i = 0; i < n - 1; i++) {
            long weight = Math.abs(point.get(i).z - point.get(i + 1).z);
            graph.add(new Road(point.get(i).i, point.get(i + 1).i, weight));
        }

        Collections.sort(graph, (o1, o2) -> (int) (o1.weight - o2.weight));
        for (Road r : graph) {
            int x = find(parent, r.x);
            int y = find(parent, r.y);
            if (x != y) {
                result += r.weight;
                union(parent, x, y);
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

    private static class Point {
        private int i, x, y, z;

        public Point(int i, int x, int y, int z) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static class Road {
        private int x, y;
        private long weight;

        public Road(int x, int y, long weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}