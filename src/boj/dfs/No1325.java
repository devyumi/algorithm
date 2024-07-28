package boj.dfs;

import java.io.*;
import java.util.*;

public class No1325 {
    private static int n;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        result = new int[n + 1];


        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
        }

        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i < n + 1; i++) {
            if (max == result[i]) {
                bw.write(i + " ");
            }
        }
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : graph[now]) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    result[i]++;
                }
            }
        }
    }
}