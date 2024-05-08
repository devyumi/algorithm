package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No7465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;

            int[] parent = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y;
                if (st.hasMoreTokens()) {
                    y = Integer.parseInt(st.nextToken());
                } else {
                    y = x;
                }
                union(parent, x, y);
            }
            
            for (int i = 1; i < n + 1; i++) {
                parent[i] = find(parent, i);
            }

            Arrays.sort(parent);
            int tmp = -1;
            for (int i = 1; i < n + 1; i++) {
                if (tmp != parent[i]) {
                    answer++;
                    tmp = parent[i];
                }
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int x1 = find(parent, x);
        int y1 = find(parent, y);
        if (x1 < y1) {
            parent[y1] = x1;
        } else {
            parent[x1] = y1;
        }
    }
}