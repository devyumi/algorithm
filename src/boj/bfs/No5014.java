package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5014 {
    private static int f;
    private static int g;
    private static int u;
    private static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        bw.write(bfs(s));
        bw.close();
    }

    private static String bfs(int start) {
        int[] weight = new int[f + 1];
        boolean[] visited = new boolean[f + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == g) {
                return weight[g] + "";
            }

            if (now + u >= 1 && now + u <= f && !visited[now + u]) {
                weight[now + u] = weight[now] + 1;
                visited[now + u] = true;
                queue.offer(now + u);
            }

            if (now - d >= 1 && now - d <= f && !visited[now - d]) {
                weight[now - d] = weight[now] + 1;
                visited[now - d] = true;
                queue.offer(now - d);
            }
        }
        return "use the stairs";
    }
}