package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1097 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] go = new int[19][19];
        int count, x, y;

        for (int i = 0; i < go.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < go.length; j++) {
                go[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = Integer.parseInt(br.readLine());
        while (count != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for (int i = 0; i < go.length; i++) {
                if (go[i][y - 1] == 0) {
                    go[i][y - 1] = 1;
                } else {
                    go[i][y - 1] = 0;
                }
            }
            for (int j = 0; j < go.length; j++) {
                if (go[x - 1][j] == 0) {
                    go[x - 1][j] = 1;
                } else {
                    go[x - 1][j] = 0;
                }
            }
            count--;
        }
        for (int i = 0; i < go.length; i++) {
            for (int j = 0; j < go.length; j++) {
                System.out.print(go[i][j] + " ");
            }
            System.out.println();
        }
    }
}
