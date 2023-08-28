package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1098 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[][] grid = new int[height][width];
        int n = Integer.parseInt(br.readLine());
        int l, d, x, y;

        while (n != 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (d == 0) {
                for (int i = 0; i < l; i++) {
                    grid[x - 1][y - 1 + i] = 1;
                }
            }

            if (d == 1) {
                for (int i = 0; i < l; i++) {
                    grid[x - 1 + i][y - 1] = 1;
                }
            }
            n--;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}