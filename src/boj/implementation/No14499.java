package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14499 {

  private static int n;
  private static int m;
  private static int x;
  private static int y;
  private static int[][] map;
  private static int[] dice;
  private static final int[] dx = {0, 0, -1, 1};
  private static final int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    dice = new int[7];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      int command = Integer.parseInt(st.nextToken());
      roll(command, sb);
    }
    System.out.print(sb.deleteCharAt(sb.length() - 1));
    br.close();
  }

  private static void roll(int command, StringBuilder sb) {
    int nx = x + dx[command - 1];
    int ny = y + dy[command - 1];

    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
      int tmp = dice[6];
      switch (command) {
        case 1:
          dice[6] = dice[3];
          dice[3] = dice[1];
          dice[1] = dice[4];
          dice[4] = tmp;
          break;
        case 2:
          dice[6] = dice[4];
          dice[4] = dice[1];
          dice[1] = dice[3];
          dice[3] = tmp;
          break;
        case 3:
          dice[6] = dice[5];
          dice[5] = dice[1];
          dice[1] = dice[2];
          dice[2] = tmp;
          break;
        case 4:
          dice[6] = dice[2];
          dice[2] = dice[1];
          dice[1] = dice[5];
          dice[5] = tmp;
          break;
      }
      x = nx;
      y = ny;

      if (map[x][y] == 0) {
        map[x][y] = dice[6];
      } else {
        dice[6] = map[x][y];
        map[x][y] = 0;
      }
      sb.append(dice[1]).append("\n");
    }
  }
}
