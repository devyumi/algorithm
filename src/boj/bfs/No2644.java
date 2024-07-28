package boj.bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2644 {
    private static ArrayList<Integer>[] list;
    private static int[] weight;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        weight = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        bw.write(String.valueOf(bfs(x, y)));
        bw.close();
    }

    private static int bfs(int x, int y) {
        visited[x] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < list[now].size(); i++) {
                if (!visited[list[now].get(i)]) {
                    weight[list[now].get(i)] = weight[now] + 1;
                    visited[list[now].get(i)] = true;
                    queue.offer(list[now].get(i));
                    if (list[now].get(i) == y) {
                        return weight[y];
                    }
                }
            }
        }
        return -1;
    }
}