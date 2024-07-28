package boj.shortestPath;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] distance = new int[n + 1];
        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = (int) 1e9;
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[x].add(new Edge(y, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(graph, distance, start);
        bw.write(String.valueOf(distance[end]));
        bw.close();
    }

    private static void dijkstra(ArrayList<Edge>[] graph, int[] distance, int start) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        pQ.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();

            if (distance[now.node] < now.weight) {
                continue;
            }

            for (int i = 0; i < graph[now.node].size(); i++) {
                Edge next = graph[now.node].get(i);
                if (distance[next.node] > distance[now.node] + next.weight) {
                    distance[next.node] = distance[now.node] + next.weight;
                    pQ.offer(new Edge(next.node, distance[next.node]));
                }
            }
        }
    }

    private static class Edge {
        private int node;
        private int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}