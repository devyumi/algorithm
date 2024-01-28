package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//backTracking 조합
public class No15686 {
    private static int m;
    private static int min;
    private static boolean[] visited;
    private static ArrayList<Point> homes;
    private static ArrayList<Point> chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = (int) 1e9;
        homes = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homes.add(new Point(i, j));
                } else if (num == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chickens.size()];
        backTracking(0, 0);

        bw.write(String.valueOf(min));
        bw.close();
    }

    private static void backTracking(int start, int depth) {
        if (m == depth) {
            int sum = 0;
            for (int i = 0; i < homes.size(); i++) {
                int tmp = (int) 1e9;
                int hx = homes.get(i).x;
                int hy = homes.get(i).y;
                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(chickens.get(j).x - hx) + Math.abs(chickens.get(j).y - hy);
                        tmp = Math.min(tmp, distance);
                    }
                }
                sum += tmp;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(i + 1, depth + 1);
                visited[i] = false;
            }
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