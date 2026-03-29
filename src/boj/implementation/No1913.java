package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1913 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] arr;
    private static int nowNum = 1;
    private static int nowX;
    private static int nowY;
    private static int nowDirection = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int checkNum = Integer.parseInt(br.readLine());
        int checkX = 0;
        int checkY = 0;
        arr = new int[n][n];
        nowX = n / 2;
        nowY = n / 2;
        arr[nowX][nowY] = nowNum++;
        int moveLen = 1;
        int count = 0; //2번 움직임 확인
        nowDirection = 0; //상 방향으로 시작

        StringBuilder sb = new StringBuilder();

        while (true) {
            if (nowNum > n * n) {
                break;
            }

            for (int i = 0; i < moveLen; i++) {
                if (nowNum > n * n) {
                    break;
                }
                MoveSnail();
            }

            count++;
            nowDirection = changeDirection(nowDirection);

            if (count == 2) {
                moveLen++;
                count = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");

                if (arr[i][j] == checkNum) {
                    checkX = i + 1;
                    checkY = j + 1;
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }

        sb.append(checkX).append(" ").append(checkY);
        System.out.print(sb);
        br.close();
    }

    private static void MoveSnail() {
        int nextX = nowX + dx[nowDirection];
        int nextY = nowY + dy[nowDirection];

        arr[nextX][nextY] = nowNum++;

        nowX = nextX;
        nowY = nextY;
    }

    private static int changeDirection(int nowDirection) {
        switch (nowDirection) {
            case 3:
                nowDirection = 1;
                break;
            case 1:
                nowDirection = 2;
                break;
            case 2:
                nowDirection = 0;
                break;
            case 0:
                nowDirection = 3;
                break;
        }
        return nowDirection;
    }
}
