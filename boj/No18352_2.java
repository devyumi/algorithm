package boj;

import java.io.*;
import java.util.*;

public class No18352_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        dijkstra(graph, distance, x);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] == k) {
                sb.append(i + "\n");
            }
        }
        if (sb.length() == 0) {
            sb.append(-1);
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void dijkstra(ArrayList<Integer>[] graph, int[] distance, int start) {
        Queue<Integer> queue = new LinkedList<>();
        distance[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : graph[now]) {
                if (distance[i] > distance[now] + 1) {
                    distance[i] = distance[now] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}