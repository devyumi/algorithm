package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No23288 {

  private static int n;
  private static int m;
  private static int[][] arr;
  private static int[][] score;
  private static boolean[][] visited;
  private static int[] dice = {2, 4, 1, 3, 5, 6}; //밑면: index 5
  private static int[] dx = {0, 1, 0, -1};  //동 남 서 북
  private static int[] dy = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    arr = new int[n][m];
    score = new int[n][m];
    int answer = 0;

    //주사위 초기 Point (0, 0)
    int[] dicePoint = {0, 0};

    //주사위 초기 방향 동쪽
    int direction = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    //이동 횟수만큼 반복
    for (int i = 0; i < k; i++) {

      //1. 주사위 한 칸 구르기. map을 벗어나면 direction 반대로 지정
      int nx = dicePoint[0] + dx[direction];
      int ny = dicePoint[1] + dy[direction];
      if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
        if (direction == 0) {
          direction = 2;
        } else if (direction == 1) {
          direction = 3;
        } else if (direction == 2) {
          direction = 0;
        } else if (direction == 3) {
          direction = 1;
        }
      }

      //2. 주사위 이동함
      dicePoint[0] += dx[direction];
      dicePoint[1] += dy[direction];

      //3. 점수 획득
      visited = new boolean[n][m];
      answer += bfs(dicePoint[0], dicePoint[1]);

      //4. 주사위 전개도 이동
      changeDice(dice, direction);

      //5. 주사위 아랫면과 주사위가 있는 칸 비교 후 방향 전환
      //90도 시계 방향 회전
      if (dice[5] > arr[dicePoint[0]][dicePoint[1]]) {
        direction = (direction + 1) % 4;

        //주사위 90도 반시계 방향 회전
      } else if (dice[5] < arr[dicePoint[0]][dicePoint[1]]) {
        direction = (direction - 1) % 4;
        if (direction == -1) {
          direction = 3;
        }
      }
    }
    System.out.print(answer);
    br.close();
  }

  private static void changeDice(int[] dice, int direction) {
    int tmp = dice[5]; //밑면 값 저장

    switch (direction) {
      case 0:
        dice[5] = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = tmp;
        break;

      case 1:
        dice[5] = dice[4];
        dice[4] = dice[2];
        dice[2] = dice[0];
        dice[0] = tmp;
        break;

      case 2:
        dice[5] = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = tmp;
        break;

      case 3:
        dice[5] = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[4];
        dice[4] = tmp;
        break;
    }
  }

  private static int bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    int cnt = 0;

    queue.offer(new int[]{x, y});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]
            && arr[nx][ny] == arr[x][y]) {
          visited[nx][ny] = true;
          cnt++;
          queue.offer(new int[]{nx, ny});
        }
      }
    }

    if (cnt == 0) {
      cnt = 1;
    }
    return arr[x][y] * cnt;
  }
}
