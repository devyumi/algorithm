package boj.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No20055 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int answer = 1;

    int[][] arr = new int[2][n];
    boolean[][] robot = new boolean[2][n];

    st = new StringTokenizer(br.readLine());
    //윗줄 초기화
    for (int i = 0; i < n; i++) {
      arr[0][i] = Integer.parseInt(st.nextToken());
    }

    //아랫줄 초기화
    for (int i = n - 1; i >= 0; i--) {
      arr[1][i] = Integer.parseInt(st.nextToken());
    }

    while (true) {
      turnRightBelt(arr, robot, n);
      turnRightRobot(arr, robot, n);

      if (arr[0][0] != 0) {
        robot[0][0] = true;
        arr[0][0]--;
      }

      if (checkCount(arr, n, k)) {
        break;
      }
      answer++;
    }
    bw.write(String.valueOf(answer));
    bw.close();
    br.close();
  }

  private static void turnRightBelt(int[][] arr, boolean[][] robot, int n) {
    int tmp = arr[1][0];

    //밑줄 옮기기
    for (int i = 1; i < n; i++) {
      arr[1][i - 1] = arr[1][i];
    }

    //가장 오른쪽 옮기기
    arr[1][n - 1] = arr[0][n - 1];

    //윗줄 옮기기 (로봇 제거 동시에)
    for (int i = n - 2; i >= 0; i--) {
      arr[0][i + 1] = arr[0][i];

      if (robot[0][i]) {
        robot[0][i] = false;
        robot[0][i + 1] = true;
      }

      if (robot[0][n - 1]) {
        robot[0][n - 1] = false;
      }
    }

    //tmp 넣기
    arr[0][0] = tmp;
  }

  private static void turnRightRobot(int[][] arr, boolean[][] robot, int n) {
    //윗줄 확인(옮길 공간에 로봇 없어야 됨, 가장 먼저 올라간 로봇부터, 로봇 제거 동시에)
    for (int i = n - 2; i >= 0; i--) {
      if (robot[0][i] && !robot[0][i + 1] && arr[0][i + 1] != 0) {
        robot[0][i] = false;
        robot[0][i + 1] = true;
        arr[0][i + 1]--;
      }

      if (robot[0][n - 1]) {
        robot[0][n - 1] = false;
      }
    }
  }

  private static boolean checkCount(int[][] arr, int n, int k) {
    int cnt = 0;

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == 0) {
          cnt++;
        }
      }
    }

    if (cnt >= k) {
      return true;
    } else {
      return false;
    }
  }
}
