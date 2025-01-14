package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7569 {
    private static int m;
    private static int n;
    private static int h;
    private static int[][][] arr;

    //상하좌우위아래
    private static final int[] dx = {0, 0, -1, 1, 0, 0};
    private static final int[] dy = {0, 0, 0, 0, -1, 1};
    private static final int[] dz = {1, -1, 0, 0, 0, 0};
    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[n][m][h];
        queue = new LinkedList<>();
        boolean isRipen = true;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 0 && isRipen) {
                        isRipen = false;
                    }

                    //익었다면 주변 탐색
                    if (arr[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }
        if (isRipen) {
            System.out.print(0);
        } else {
            bfs();
            System.out.print(solve());
        }
        br.close();
    }

    //익은 상태 정수가 모두 다르므로 visited 사용할 필요 없음
    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2] + dz[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h || arr[nx][ny][nz] != 0) {
                    continue;
                }
                arr[nx][ny][nz] = arr[now[0]][now[1]][now[2]] + 1;
                queue.offer(new int[]{nx, ny, nz});
            }
        }
    }

    private static int solve() {
        int max = -1;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    } else {
                        max = Math.max(max, arr[i][j][k]);
                    }
                }
            }
        }
        return max - 1;
    }
}