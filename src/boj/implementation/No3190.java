package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No3190 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //순서: 우 하 좌 상
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    int answer = 0;

    //map
    int[][] arr = new int[n][n];

    //뱀 위치 저장
    ArrayList<Point> list = new ArrayList<>();

    //사과 위치 저장
    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      arr[x][y] = 1;
    }

    int l = Integer.parseInt(br.readLine());

    //시간에 따른 뱀 방향 변환 저장
    Snack[] snacks = new Snack[l];
    for (int i = 0; i < l; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      snacks[i] = new Snack(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
    }

    //뱀 방향 인덱스
    int snackIndex = 0;

    //뱀 초기 방향 (우)
    int direction = 0;

    //시작
    int cx = 0;
    int cy = 0;
    list.add(new Point(cx, cy));

    Loop:
    while (true) {
      answer++; //시작하자마자 +1초

      // 1. 방향을 바꿀 때면 바꾼다.
      if (snackIndex < l && answer - 1 == snacks[snackIndex].second) {
        char d = snacks[snackIndex++].direction;

        switch (d) {
          case 'L':
            direction--;
            if (direction <= -1) {
              direction = 3;
            }
            break;

          case 'D':
            direction++;
            if (direction >= 4) {
              direction = 0;
            }
            break;
        }
      }
      int nx = cx + dx[direction];
      int ny = cy + dy[direction];

      //벽이면 break;
      if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
        break Loop;
      }

      //자신의 몸 밟으면 break;
      for (Point p : list) {
        if (p.x == nx && p.y == ny) {
          break Loop;
        }
      }

      //앞으로 전진
      list.add(new Point(nx, ny));

      //사과 있음: 몸통 앞으로 이동, 사과 제거
      if (arr[nx][ny] == 1) {
        arr[nx][ny] = 0;

        //사과 없음: 꼬리 삭제
      } else {
        list.remove(0);
      }

      cx = nx;
      cy = ny;
    }
    System.out.print(answer);
    br.close();
  }

  private static class Snack {

    private int second;
    private char direction;

    public Snack(int second, char direction) {
      this.second = second;
      this.direction = direction;
    }
  }

  private static class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
