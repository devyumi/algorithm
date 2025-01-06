package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No4485 {
    private static int n;
    private static int[][] arr;
    private static int[][] shortestMap;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            arr = new int[n][n];
            shortestMap = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    shortestMap[i][j] = Integer.MAX_VALUE;
                }
            }
            sb.append("Problem ").append(t++).append(": ").append(bfs()).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1).toString());
        br.close();
    }

    //최소 금액 == 최단 거리 == bfs (사실상 dijkstra)
    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        //링크는 반드시 (0,0)에서 출발한다.
        queue.add(new int[]{0, 0});
        shortestMap[0][0] = arr[0][0];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int[] next = {now[0] + dx[i], now[1] + dy[i]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) {
                    continue;
                }

                if (shortestMap[next[0]][next[1]] > shortestMap[now[0]][now[1]] + arr[next[0]][next[1]]) {
                    shortestMap[next[0]][next[1]] = shortestMap[now[0]][now[1]] + arr[next[0]][next[1]];
                    queue.offer(new int[]{next[0], next[1]});
                }
            }
        }
        return shortestMap[n - 1][n - 1];
    }
}
