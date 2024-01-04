package boj;

import java.io.*;
import java.util.*;

public class No18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] min = new int[n + 1];
        Arrays.fill(min, -1);

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        bfs(graph, min, x);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (min[i] == k) {
                sb.append(i + "\n");
            }
        }

        if (sb.length() == 0) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(sb.toString());
        }
        bw.close();
    }

    private static void bfs(ArrayList<Integer>[] graph, int[] min, int x) {
        Queue<Integer> queue = new LinkedList<>();
        min[x] = 0;
        queue.offer(x);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (min[next] != -1) {
                    continue;
                }
                min[next] = min[now] + 1;
                queue.offer(next);
            }
        }
    }
}