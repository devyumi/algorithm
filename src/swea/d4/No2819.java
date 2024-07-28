package swea.d4;

import java.io.*;
import java.util.*;

public class No2819 {
    private static String[][] arr;
    private static HashSet<String> set;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            arr = new String[4][4];
            set = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = st.nextToken();
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, 0, arr[i][j]);
                }
            }

            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void dfs(int x, int y, int depth, String result) {
        if (depth == 6) {
            set.add(result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                dfs(nx, ny, depth + 1, result + arr[nx][ny]);
            }
        }
    }
}