package ndb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No44 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];
        for (int i = 0; i < map[0].length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] currentD = direction[d];
        map[x][y] = 1;
        int count = 1;

        Loop1:
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (d == 0) {
                    d = 3;
                } else {
                    d--;
                }
                currentD = direction[d];

                if (map[x + currentD[0]][y + currentD[1]] == 1) {
                    continue;
                }

                if (map[x + currentD[0]][y + currentD[1]] == 0) {
                    x += currentD[0];
                    y += currentD[1];
                    map[x][y] = 1;
                    count++;
                    i = -1;
                }
            }

            if (map[x - currentD[0]][y - currentD[1]] == 1) {
                break Loop1;
            }

            if (map[x - currentD[0]][y - currentD[1]] == 0) {
                x -= currentD[0];
                y -= currentD[1];
            }
        }
        System.out.print(count);
    }
}