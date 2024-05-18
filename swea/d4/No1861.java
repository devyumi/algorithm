package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1861 {
    private static int n;
    private static int[][] arr;
    private static int count;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            int room = 0;
            int max = -1;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    count = 1;
                    int result = dfs(i, j);
                    if (max < result) {
                        room = arr[i][j];
                        max = result;
                    } else if (max == result) {
                        room = room < arr[i][j] ? room : arr[i][j];
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(room).append(" ").append(max).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] - arr[x][y] == 1) {
                count++;
                dfs(nx, ny);
            }
        }
        return count;
    }
}