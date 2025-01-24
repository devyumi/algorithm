package boj.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] list = new ArrayList[n];
        int[] distance = new int[n];

        for (int i = 1; i < n; i++) {
            list[i] = new ArrayList<>();
            distance[i] = (int) 1e9;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, w));
            list[b].add(new Edge(a, w));
        }

        System.out.print(dijkstra(list, distance));
        br.close();
    }

    private static int dijkstra(ArrayList<Edge>[] list, int[] distance) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        distance[1] = 0;

        pQ.offer(new Edge(1, 0));

        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();

            if (distance[now.node] < now.weight) {
                continue;
            }

            for (int i = 0; i < list[now.node].size(); i++) {
                Edge next = list[now.node].get(i);

                if (distance[next.node] > distance[now.node] + next.weight) {
                    distance[next.node] = distance[now.node] + next.weight;
                    pQ.offer(new Edge(next.node, distance[next.node]));
                }
            }
        }
        int answer = distance[distance.length - 1];
        if (answer == (int) 1e9) {
            answer = 0;
        }
        return answer;
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
