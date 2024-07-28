package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1954 {
    private static int n;
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + "\n");
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            solution();
            printArr(sb);
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void solution() {
        arr[0][0] = 1;
        int count = 2;
        int x = 0;
        int y = 0;
        int direction = 0;

        while (count <= n * n) {
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                if (arr[nextX][nextY] == 0) {
                    arr[nextX][nextY] = count;
                    count++;

                    x = nextX;
                    y = nextY;
                } else {
                    direction = (direction + 1) % 4;
                }
            } else {
                direction = (direction + 1) % 4;
            }
        }
    }

    private static void printArr(StringBuilder sb) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
    }
}