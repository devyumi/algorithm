package softeer;

import java.io.*;
import java.util.*;

public class 함께하는효도 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static ArrayList<int[]> list;
    private static int answer;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        list = new ArrayList<>();
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            list.add(new int[]{x1, y1});
        }
        backTracking(list.get(0)[0], list.get(0)[1], arr[list.get(0)[0]][list.get(0)[1]], 0, 0);
        System.out.println(answer);
        br.close();

    }
    private static void backTracking(int x, int y, int sum, int friend ,int depth) {
        visited[x][y] = true;

        if (depth == 3) {
            if (friend + 1 < m) {
                backTracking(list.get(friend + 1)[0], list.get(friend + 1)[1], sum + arr[list.get(friend + 1)[0]][list.get(friend + 1)[1]], friend + 1, 0);
            } else {
                answer = Math.max(answer, sum);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    sum += arr[nx][ny];
                    visited[nx][ny] = true;
                    backTracking(nx, ny, sum, friend, depth + 1);
                    sum -= arr[nx][ny];
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
