package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No2589 {
    private static int n;
    private static int m;
    private static char[][] arr;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr = new char[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = str[j].charAt(0);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        System.out.print(max);
        br.close();
    }

    private static int bfs (int x, int y) {
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int max = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            max = Math.max(max, distance[now[0]][now[1]]);

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 'W' || visited[nx][ny]) {
                    continue;
                }
                //최대 거리 계산
                distance[nx][ny] = distance[now[0]][now[1]] + 1;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
        return max;
    }
}