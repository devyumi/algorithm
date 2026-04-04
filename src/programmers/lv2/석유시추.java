package programmers.lv2;

import java.util.*;

public class 석유시추 {
    class Solution {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n;
        int m;
        int[][] landsId;
        boolean[][] visited;

        public int solution(int[][] land) {
            int answer = 0;
            n = land.length;
            m = land[0].length;
            landsId = new int[n][m];
            visited = new boolean[n][m];
            Map<Integer, Integer> maps = new HashMap<>();
            int id = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (land[i][j] == 1 && !visited[i][j]) {
                        int sum = bfs(land, i, j, id);
                        maps.put(id++, sum);
                    }
                }
            }

            for (int j = 0; j < m; j++) {
                Set<Integer> set = new HashSet<>();
                int sum = 0;

                for (int i = 0; i < n; i++) {
                    if (landsId[i][j] > 0) {
                        set.add(landsId[i][j]);
                    }
                }

                for (int k : set) {
                    sum += maps.get(k);
                }
                answer = Math.max(answer, sum);
            }
            return answer;
        }

        private int bfs(int[][] land, int x, int y, int id) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});
            int sum = 1;
            visited[x][y] = true;
            landsId[x][y] = id;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = now[0] + dx[i];
                    int nextY = now[1] + dy[i];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && land[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        sum++;
                        visited[nextX][nextY] = true;
                        landsId[nextX][nextY] = id;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            return sum;
        }
    }
}
