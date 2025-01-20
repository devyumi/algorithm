package boj.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        int answer = (int) 1e9;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = (int) 1e9;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        //가장 작은 사이클 찾기: (1,2), (2,1) 형식
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][j] != (int) 1e9 && arr[j][i] != (int) 1e9) {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }

        if (answer == (int) 1e9) {
            System.out.print(-1);
        } else {
            System.out.print(answer);
        }
        br.close();
    }
}
