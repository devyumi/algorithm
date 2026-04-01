package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2667 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int n;
    private static boolean[][] visited;
    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        visited = new boolean[n][n];
        queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int neighbourhoods = 0;

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp[j] - '0';
                if (arr[i][j] == 0) {
                    visited[i][j] = true; //0이면 탐색 안 함
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    neighbourhoods++; //단지 +1

                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    int result = bfs();
                    arrayList.add(result);
                }
            }
        }

        //결과 출력
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        
        sb.append(neighbourhoods).append("\n");
        for (int i : arrayList) {
            sb.append(i).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int bfs() {
        int sum = 1; //시작할 때 기본으로 한 개 들어가 있음

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            int nowX = point[0];
            int nowY = point[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}