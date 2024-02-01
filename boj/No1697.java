package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {
    private static int k;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bw.write(String.valueOf(bfs(n)));
        bw.close();
    }

    private static int bfs(int start) {
        Queue<Hiding> queue = new LinkedList<>();
        queue.offer(new Hiding(start, 0));

        while (!queue.isEmpty()) {
            Hiding tmp = queue.poll();
            if (tmp.x < 0 || tmp.x > 100000) {
                continue;
            }

            if (tmp.x == k) {
                return tmp.second;
            }

            if (!visited[tmp.x]) {
                visited[tmp.x] = true;
                queue.offer(new Hiding(tmp.x - 1, tmp.second + 1));
                queue.offer(new Hiding(tmp.x + 1, tmp.second + 1));
                queue.offer(new Hiding(tmp.x * 2, tmp.second + 1));
            }
        }
        return 0;
    }

    private static class Hiding {
        private int x;
        private int second;

        public Hiding(int x, int second) {
            this.x = x;
            this.second = second;
        }
    }
}