package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No1249 {
    private static int n;
    private static Road[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new Road[n][n];

            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    int weight = Integer.parseInt(str[j]);
                    arr[i][j] = new Road(i, j, weight, (int) 1e9);
                }
            }
            bfs();
            sb.append("#").append(t).append(" ").append(arr[n - 1][n - 1].distance).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Road> queue = new LinkedList<>();
        queue.offer(new Road(0, 0, arr[0][0].weight, 0));

        while (!queue.isEmpty()) {
            Road now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int nd = now.distance + arr[nx][ny].weight;
                    if (arr[nx][ny].distance > nd) {
                        arr[nx][ny].distance = nd;
                        queue.offer(new Road(nx, ny, arr[nx][ny].weight, nd));
                    }
                }
            }
        }
    }

    private static class Road {
        private int x;
        private int y;
        private int weight;
        private int distance;

        public Road(int x, int y, int weight, int distance) {
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.distance = distance;
        }
    }
}