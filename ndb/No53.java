package ndb;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs, 이코테에는 dfs로 소개되었지만 bfs로 풂 (개수 구하기)
public class No53 {
    static int n;
    static int m;
    static int[][] ice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ice = new int[n][m];
        int iceCream = 0;
        for (int i = 0; i < ice.length; i++) {
            String[] token = br.readLine().split("");
            for (int j = 0; j < ice[i].length; j++) {
                ice[i][j] = Integer.parseInt(token[j]);
            }
        }

        for (int i = 0; i < ice.length; i++) {
            for (int j = 0; j < ice[i].length; j++) {
                iceCream += bfs(i, j);
            }
        }
        bw.write(String.valueOf(iceCream));
        bw.close();
    }

    private static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        if(ice[x][y] == 1){
            return 0;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (ice[nextX][nextY] == 1) {
                    continue;
                }
                if (ice[nextX][nextY] == 0) {
                    ice[nextX][nextY] = 1;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
        return 1;
    }

    private static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
