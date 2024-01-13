package ndb;

import java.io.*;

public class Q42 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int max = 0;
        int[] parent = new int[g + 1];

        for (int i = 0; i < g + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < p; i++) {
            int x = find(parent, Integer.parseInt(br.readLine()));
            if (x != 0) {
                union(parent, x, x - 1);
                max++;
            } else {
                break;
            }
        }
        bw.write(String.valueOf(max));
        bw.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int pX = find(parent, x);
        int pY = find(parent, y);

        if (pX < pY) {
            parent[pY] = pX;
        } else {
            parent[pX] = pY;
        }
    }
}