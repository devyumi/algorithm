package boj.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1916 {
    private static int[] distance;
    private static ArrayList<Edge>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + 1;
        int m = Integer.parseInt(br.readLine());
        distance = new int[n];
        list = new ArrayList[n];

        for (int i = 1; i < n; i++) {
            distance[i] = (int) 1e9;
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.print(dijkstra(start, end));
        br.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pQ.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();

            //시작점에서 now로 가는 최단 거리보다 now의 weight이 크면 업데이트할 필요가 없음
            if (distance[now.node] < now.weight) {
                continue;
            }

            for (int i = 0; i < list[now.node].size(); i++) {
                Edge next = list[now.node].get(i);

                //시작점에서 next로 가는 최단 경로보다 now를 거쳐 next로 가는 것이 더 짧다면 업데이트
                if (distance[next.node] > distance[now.node] + next.weight) {
                    distance[next.node] = distance[now.node] + next.weight;
                    pQ.offer(new Edge(next.node, distance[next.node]));
                }
            }
        }
        return distance[end];
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