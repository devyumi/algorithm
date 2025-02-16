package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2573 {
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[n][m];
            int ice = 0;
            int sum = 0;

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        ice += bfs(i, j);
                    }
                }
               sum += Arrays.stream(arr[i]).sum();
            }

            //모든 빙하가 녹음
            if (sum == 0) {
                answer = 0;
                break;
            }

            //빙하가 없거나 두 덩어리 이상 분리
            if (ice == 0 || ice >= 2) {
                break;
            } else {
                decreaseIce(n, m);
            }
            answer++;
        }
        System.out.print(answer);
        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (arr[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return 1;
    }

    private static void decreaseIce(int n, int m) {
        int[][] tmp = new int[n][m];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                int ocean = 0;
                for (int k = 0; k < 4; k++) {
                    if (arr[i + dx[k]][j + dy[k]] == 0) {
                        ocean++;
                    }
                }
                if (arr[i][j] - ocean <= 0) {
                    tmp[i][j] = 0;
                } else {
                    tmp[i][j] = arr[i][j] - ocean;
                }
            }
        }
        arr = tmp;
    }
}
