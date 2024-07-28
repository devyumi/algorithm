package ndb;

import java.io.*;
import java.util.*;

//dijkstra
public class Q40 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dijkstra(graph, visited, 1);

        int point = n + 1;
        int distance = Arrays.stream(visited).max().getAsInt();
        int samePoint = 0;

        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == distance && point > i) {
                point = i;
            }

            if (visited[i] == distance) {
                samePoint++;
            }
        }

        bw.write(point + " " + distance + " " + samePoint);
        bw.close();
    }

    private static void dijkstra(ArrayList<Integer>[] graph, int[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (visited[next] != -1) {
                    continue;
                }
                queue.offer(next);
                visited[next] = visited[now] + 1;
            }
        }
    }
}