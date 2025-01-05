package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10026 {

    private static int n;
    private static char[][] arr;
    private static boolean[][] visited;
    private static char tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        tmp = 0;
        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = str[j].charAt(0);
            }
        }

        //일반 구역
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    tmp = arr[i][j];
                    answer1 += dfs(i, j);
                }
            }
        }

        //적녹색약 구역을 구하기 위해 G -> R로 치환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        //적녹색약 구역
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    tmp = arr[i][j];
                    answer2 += dfs(i, j);
                }
            }
        }

        System.out.print(answer1 + " " + answer2);
        br.close();
    }

    //메모리 제한 128MB로 dfs 사용함
    private static int dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }

        if (!visited[x][y]) {
            if (arr[x][y] == tmp) {
                visited[x][y] = true;
                dfs(x - 1, y);
                dfs(x + 1, y);
                dfs(x, y - 1);
                dfs(x, y + 1);
                return 1;
            }
        }
        return 0;
    }
}