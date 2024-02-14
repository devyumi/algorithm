package boj.backTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15686 {
    private static int m;
    private static ArrayList<Point> chickens;
    private static ArrayList<Point> homes;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<>();
        homes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    homes.add(new Point(i, j));
                } else if (tmp == 2) {
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
        if (depth == m) {
            int sum = 0;
            for (int i = 0; i < homes.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(homes.get(i).x - chickens.get(j).x) + Math.abs(homes.get(i).y - chickens.get(j).y);
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