package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No4179 {
    private static int r;
    private static int c;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        String[][] person = new String[r][c];
        String[][] fire = new String[r][c];
        Queue<int[]> personQ = new LinkedList<>();
        Queue<int[]> fireQ = new LinkedList<>();
        int[] point = new int[2];

        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                person[i][j] = str[j];
                fire[i][j] = person[i][j];

                if (fire[i][j].equals("J")) {
                    personQ.offer(new int[]{i, j});
                    person[i][j] = "0";
                    fire[i][j] = ".";
                    point[0] = i;
                    point[1] = j;
                } else if (fire[i][j].equals("F")) {
                    fireQ.offer(new int[]{i, j});
                    fire[i][j] = "0";
                    person[i][j] = ".";
                }
            }
        }

        //이미 사람의 위치가 가장자리라면 탐색하지 않고 정답 도출
        if (point[0] == r - 1 || point[1] == c - 1 || point[0] == 0 || point[1] == 0) {
            System.out.print(1);
        } else {
            bfs(fire, fireQ);
            bfs(person, personQ);
            calTime(person, fire, point);
        }
        br.close();
    }

    private static void bfs(String[][] arr, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || arr[nx][ny].equals("#")) {
                    continue;
                }

                if (arr[nx][ny].equals(".")) {
                    arr[nx][ny] = String.valueOf(Integer.parseInt(arr[now[0]][now[1]]) + 1);
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static void calTime(String[][] person, String[][] fire, int[] point) {
        int answer = 1001;

        //가장자리면서 최소 시간일 때만 업데이트
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (person[i][j].equals("#") || person[i][j].equals(".")) {
                    continue;
                }

                if (fire[i][j].equals("#") || fire[i][j].equals(".")) {
                    if (answer > Integer.parseInt(person[i][j])) {
                        if (i == r - 1 || j == c - 1 || i == 0 || j == 0) {
                            answer = Integer.parseInt(person[i][j]);
                            point[0] = i;
                            point[1] = j;
                        }
                    }
                } else {
                    if (Integer.parseInt(fire[i][j]) > Integer.parseInt(person[i][j])) {
                        if (answer > Integer.parseInt(person[i][j])) {
                            if (i == r - 1 || j == c - 1 || i == 0 || j == 0) {
                                answer = Integer.parseInt(person[i][j]);
                                point[0] = i;
                                point[1] = j;
                            }
                        }
                    }
                }
            }
        }

        if (point[0] == r - 1 || point[1] == c - 1 || point[0] == 0 || point[1] == 0) {
            System.out.print(answer + 1);
        } else {
            System.out.print("IMPOSSIBLE");
        }
    }
}
