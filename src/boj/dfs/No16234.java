package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No16234 {

  private static int n;
  private static int min;
  private static int max;
  private static int[][] arr;
  private static boolean[][] visited;               //dfs 방문 처리
  private static ArrayList<int[]> open;            //열린 국경선 위치 저장
  private static final int[] dx = {-1, 1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};
  private static int team;                        // 연합 칸 개수
  private static int population;                  //인구 수

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    min = Integer.parseInt(st.nextToken());
    max = Integer.parseInt(st.nextToken());
    arr = new int[n][n];
    int answer = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      visited = new boolean[n][n];
      boolean isMove = false;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!visited[i][j]) {
            open = new ArrayList<>();

            team = 1;
            population = 0;
            population += arr[i][j];
            visited[i][j] = true;
            open.add(new int[]{i, j});

            dfs(i, j);

            //dfs 결과가 1 아닐 때(== 국경선이 열렸을 때)만 계산
            if (team != 1) {
              isMove = true;
              setPeople(population, team);
            }
          }
        }
      }

      if (!isMove) {
        break;
      } else {
        answer++;
      }
    }

    System.out.print(answer);
    br.close();
  }

  private static void dfs(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
        if (Math.abs(arr[x][y] - arr[nx][ny]) >= min && Math.abs(arr[x][y] - arr[nx][ny]) <= max) {

          visited[nx][ny] = true;

          // 방문 안 헀을 때만 더함
          if (!open.contains(new int[]{nx, ny})) {
            open.add(new int[]{nx, ny});
            team++;
            population += arr[nx][ny];
            dfs(nx, ny);
          }
        }
      }
    }
  }

  private static void setPeople(int population, int allCnt) {
    //인구 수 다시 계산
    int newPopulation = population / allCnt;

    for (int[] i : open) { //국경선 열린 곳만 바꿔줌
      arr[i[0]][i[1]] = newPopulation;
    }
  }
}
