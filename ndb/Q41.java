package ndb;

import java.io.*;
import java.util.StringTokenizer;

public class Q41 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];
        int[] plan = new int[m];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    union(parent, i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        boolean result = true;
        for (int i = 0; i < m - 1; i++) {
            if (find(parent, plan[i]) != find(parent, plan[i + 1])) {
                result = false;
                break;
            }
        }

        if (result == true) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int findX = find(parent, x);
        int findY = find(parent, y);
        if (findX < findY) {
            parent[findY] = findX;
        } else {
            parent[findX] = findY;
        }
    }
}