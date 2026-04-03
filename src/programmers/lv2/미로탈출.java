package programmers.lv2;

import java.util.*;

public class 미로탈출 {
    class Solution {
        private static final int[] dx = {-1, 1, 0, 0};
        private static final int[] dy = {0, 0, -1, 1};
        private static int n;
        private static int m;
        private static char[][] arr;

        public int solution(String[] maps) {
            int answer = 0;
            n = maps.length;
            m = maps[0].length();

            arr = new char[n][m];
            int[] start = new int[2];
            int[] lever = new int[2];
            int[] end = new int[2];

            for (int i = 0; i < n; i++) {
                char[] tmp = maps[i].toCharArray();
                for (int j = 0; j < tmp.length; j++) {
                    arr[i][j] = tmp[j];

                    if (arr[i][j] == 'S') {
                        start[0] = i; start[1] = j;
                    } else if (arr[i][j] == 'L') {
                        lever[0] = i; lever[1] = j;
                    } else if (arr[i][j] == 'E') {
                        end[0] = i; end[1] = j;
                    }
                }
            }

            int toLever = bfs(start, lever);
            if (toLever == -1) {
                return -1;
            }

            int toEnd = bfs(lever, end);
            if (toEnd == -1) {
                return -1;
            }

            return toLever + toEnd;
        }

        private static int bfs(int[] start, int[] end) {
            boolean[][] visited = new boolean[n][m];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start[0], start[1], 0});
            visited[start[0]][start[1]] = true; //방문처리

            while(!queue.isEmpty()) {
                int[] now = queue.poll();

                if (now[0] == end[0] && now[1] == end[1]) {
                    return now[2];
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = now[0] + dx[i];
                    int nextY = now[1] + dy[i];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && arr[nextX][nextY] != 'X' && !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY, now[2] + 1});
                        visited[nextX][nextY] = true; //방문처리
                    }
                }
            }
            return -1;
        }
    }
}
