package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5014 {
    private static int f;
    private static int s;
    private static int g;
    private static int u;
    private static int d;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[f + 1];
        visited = new boolean[f + 1];

        bw.write(bfs(s));
        bw.close();
    }

    private static String bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        arr[x] = 0;
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == g) {
                return String.valueOf(arr[now]);
            }

            if (now + u <= f && !visited[now + u]) {
                if (arr[now + u] == 0) {
                    arr[now + u] = arr[now] + 1;
                    visited[now + u] = true;
                    queue.offer(now + u);
                }
            }

            if (now - d > 0 && !visited[now - d]) {
                if (arr[now - d] == 0) {
                    arr[now - d] = arr[now] + 1;
                    visited[now - d] = true;
                    queue.offer(now - d);
                }
            }
        }
        return "use the stairs";
    }
}