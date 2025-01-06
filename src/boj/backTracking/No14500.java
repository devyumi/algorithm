package boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14500 {

    private static int n;
    private static int m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int answer;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                backTracking(i, j, 0, arr[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.print(answer);
        br.close();
    }

    private static void backTracking(int x, int y, int depth, int sum) {
        //테트로미노는 정사각형 4개
        if (depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //모든 좌표를 and 조건으로 하는 것보다 or 조건으로 하는 것이 더 빠르다.
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (!visited[nx][ny]) {
                //ㅜ 모양 테트로미노
                if(depth == 1) {
                    visited[nx][ny] = true;
                    sum += arr[nx][ny];
                    backTracking(x, y, depth + 1, sum);
                    visited[nx][ny] = false;
                    sum -= arr[nx][ny];
                }

                //그 외 테트로미노
                visited[nx][ny] = true;
                sum += arr[nx][ny];
                backTracking(nx, ny, depth + 1, sum);
                visited[nx][ny] = false;
                sum -= arr[nx][ny];
            }
        }
    }
}
