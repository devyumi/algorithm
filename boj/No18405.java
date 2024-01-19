package boj;

import java.io.*;
import java.util.*;

//bfs
public class No18405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        ArrayList<Node> data = new ArrayList<>();
        int s, x, y;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int virus = Integer.parseInt(st.nextToken());
                graph[i][j] = virus;
                if (virus != 0) {
                    data.add(new Node(i, j, virus, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        Collections.sort(data, (o1, o2) -> o1.virus - o2.virus);

        Queue<Node> queue = new LinkedList<>();
        for (Node node : data) {
            queue.add(node);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.second == s) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = now.virus;
                        queue.add(new Node(nx, ny, now.virus, now.second + 1));
                    }
                }
            }
        }
        bw.write(String.valueOf(graph[x - 1][y - 1]));
        bw.close();
    }

    private static class Node {
        int x, y, virus, second;

        public Node(int x, int y, int virus, int second) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.second = second;
        }
    }
}