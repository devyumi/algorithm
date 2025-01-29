package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2206 {
    private static int n;
    private static int m;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs();
        br.close();
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //x, y, 최단 거리, 지금까지 벽을 부신 적 있는지
        Queue<Wall> queue = new LinkedList<>();
        queue.offer(new Wall(0, 0, 1, false));

        //[핵심] 각 길마다 부셔서 지나갔는지, 그냥 지나갔는지를 따로 저장한다.
        boolean[][][] visited = new boolean[n][m][2];

        while (!queue.isEmpty()) {
            Wall now = queue.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                System.out.print(now.distance);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                /**
                 * 1. 벽 X
                 *  1-1. 부신 적 O - 부순 표시하고 간다.
                 *  1-2. 부신 적 X - 안 부순 표시하고 간다.
                 * 2. 벽 O
                 *  2-1. 부신 적 O - 못 간다.
                 *  2-2. 부신 적 X - 부순 표시하고 간다.
                 */

                if (arr[nx][ny] == 0) {
                    if (!now.checked && !visited[nx][ny][0]) {
                        queue.offer(new Wall(nx, ny, now.distance + 1, false));
                        visited[nx][ny][0] = true;
                    }
                    else if (now.checked && !visited[nx][ny][1]) {
                        queue.offer(new Wall(nx, ny, now.distance + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else {
                    if (!now.checked) {
                        queue.offer(new Wall(nx, ny, now.distance + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.print(-1);
    }

    private static class Wall {
        private int x;
        private int y;
        private int distance;
        private boolean checked;

        public Wall(int x, int y, int distance, boolean checked) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.checked = checked;
        }
    }
}
