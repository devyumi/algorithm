package programmers.lv2;

import java.util.*;

public class 게임맵최단거리 {
    class Solution {
        public int solution(int[][] maps) {
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int n = maps.length;
            int m = maps[0].length;

            if (maps[0][0] == 0 || maps[n - 1][m - 1] == 0) {
                return -1;
            }

            return bfs(maps, dx, dy, n, m);
        }

        private int bfs(int[][] maps, int[] dx, int[] dy, int n, int m) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            boolean[][] visited = new boolean[n][m];
            visited[0][0] = true;

            while(!queue.isEmpty()) {
                int[] now = queue.poll();
                int nowX = now[0];
                int nowY = now[1];

                if (nowX == n - 1 && nowY == m - 1) {
                    System.out.println(maps[n - 1][m - 1]);
                    return maps[n - 1][m - 1];
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && maps[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        maps[nextX][nextY] = maps[nowX][nowY] + 1 ;
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            return -1;
        }
    }
}
