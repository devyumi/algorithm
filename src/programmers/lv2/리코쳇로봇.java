package programmers.lv2;

import java.util.*;

public class 리코쳇로봇 {
    class Solution {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n;
        int m;
        int[] robot;
        int[] goal;
        char[][] arr;

        public int solution(String[] board) {

            n = board.length;
            m = board[0].length();
            robot = new int[2];
            goal = new int[2];
            arr = new char[n][m];

            for (int i = 0; i < n; i++) {
                char[] tmp = board[i].toCharArray();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = tmp[j];

                    if (arr[i][j] == 'R') {
                        robot[0] = i; robot[1] = j;
                    } else if (arr[i][j] == 'G') {
                        goal[0] = i; goal[1] = j;
                    }
                }
            }
            return bfs();
        }

        private int bfs() {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{robot[0], robot[1], 0});
            boolean[][] visited = new boolean[n][m];
            visited[robot[0]][robot[1]] = true;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                if (now[0] == goal[0] && now[1] == goal[1]) {
                    return now[2];
                }

                for (int i = 0; i < 4; i++) {
                    int cnt = 1;
                    int nextX = now[0] + dx[i] * cnt;
                    int nextY = now[1] + dy[i] * cnt;

                    while (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && arr[nextX][nextY] != 'D') {
                        cnt++;
                        nextX = now[0] + dx[i] * cnt;
                        nextY = now[1] + dy[i] * cnt;
                    }

                    if (cnt != 1) {
                        cnt--;
                        nextX = now[0] + dx[i] * cnt;
                        nextY = now[1] + dy[i] * cnt;
                    }

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && arr[nextX][nextY] != 'D' && !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY, now[2] + 1});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            return -1;
        }
    }
}
