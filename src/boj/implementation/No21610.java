package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No21610 {

  private static final int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
  private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][n];
    boolean[][] visited;  //구름 제거된 칸 체크
    Queue<Point> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    //구름 처음 초기화
    queue.offer(new Point(n - 1, 0));
    queue.offer(new Point(n - 1, 1));
    queue.offer(new Point(n - 2, 0));
    queue.offer(new Point(n - 2, 1));

    //1. 구름 이동
    for (int i = 0; i < m; i++) {
      visited = new boolean[n][n];
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken()) - 1; //방향
      int s = Integer.parseInt(st.nextToken());     //위치

      //2. 구름 이동 후 Point에 비++, 3. 구름 제거
      int size = queue.size();
      for (int j = 0; j < queue.size(); j++) {
        Point now = queue.poll();

        int nx = (now.x + (dx[d] + n) * s) % n; //(0행, N-1행), (0열, N-1열)이 이어져 있음
        int ny = (now.y + (dy[d] + n) * s) % n;
        arr[nx][ny]++;
        visited[nx][ny] = true;

        queue.offer(new Point(nx, ny));
      }

      //4. 대각선에 비 있으면 + 1
      addAmount(arr, queue);

      //5. 비의 양 >= 2 인 모든 곳에 구름 추가 및 비의 양 - 2
      decreaseAmount(arr, visited, queue);
    }

    System.out.print(calAmount(arr));
    br.close();
  }

  private static void addAmount(int[][] arr, Queue<Point> queue) {
    while (!queue.isEmpty()) {
      Point now = queue.poll();

      for (int k = 1; k < 8; k += 2) {
        int nx = now.x + dx[k];
        int ny = now.y + dy[k];

        if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr.length && arr[nx][ny] != 0) {
          arr[now.x][now.y]++;
        }
      }
    }
  }

  private static void decreaseAmount(int[][] arr, boolean[][] visited, Queue<Point> queue) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (!visited[i][j] && arr[i][j] >= 2) {
          arr[i][j] -= 2;
          queue.offer(new Point(i, j)); //구름 생긴 곳의 point 값 추가
        }
      }
    }
  }

  private static int calAmount(int[][] arr) {
    int answer = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        answer += arr[i][j];
      }
    }
    return answer;
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
