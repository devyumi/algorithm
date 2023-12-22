package ndb;

import java.io.*;
import java.util.*;

//다익스트라
public class No93 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v].add(new Edge(e, w));
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        dijkstra(graph, distance, start);

        int city = 0;
        int time = 0;

        for (int i : distance) {
            if (i != INF) {
                city++;
                time = Math.max(time, i);
            }
        }
        bw.write(city - 1 + " " + time);
        bw.close();
    }

    private static class Edge {
        private int vertex;
        private int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    private static void dijkstra(ArrayList<Edge>[] graph, int[] distance, int start) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        distance[start] = 0;
        pQ.offer(new Edge(start, 0));

        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();
            if (now.weight > distance[now.vertex]) {
                continue;
            }

            for (int i = 0; i < graph[now.vertex].size(); i++) {
                Edge next = graph[now.vertex].get(i);
                if (distance[next.vertex] > distance[now.vertex] + next.weight) {
                    distance[next.vertex] = distance[now.vertex] + next.weight;
                    pQ.offer(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }
    }
}
