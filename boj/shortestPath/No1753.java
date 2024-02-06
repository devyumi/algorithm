package boj.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//다익스트라, 우선순위 큐, 2차원 ArrayList
public class No1753 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[V + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v].add(new Edge(u, w));
        }
        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);

        dijkstra(graph, distance, K);
        printDistance(distance);
    }

    private static void dijkstra(ArrayList<Edge>[] graph, int[] distance, int K) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        pQ.offer(new Edge(K, 0));
        distance[K] = 0;
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

    private static void printDistance(int[] distance) {
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    static class Edge {
        private int vertex;
        private int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}