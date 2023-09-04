package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1099 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] maze = new int[10][10];

        for (int i = 0; i < maze.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int right = 1;
        int down = 1;
        Loop1:
        while (true) {
            Loop2:
            while (true) {
                if (maze[down + 1][right] == 1 && maze[down][right + 1] == 1) {
                    maze[down][right] = 9;
                    break Loop1;
                }
                if (maze[down][right] == 2) {
                    maze[down][right] = 9;
                    break Loop1;
                }
                if (maze[down][right] == 0) {
                    maze[down][right] = 9;
                    if (maze[down][right + 1] == 1) {
                        down++;
                    } else {
                        right++;
                    }
                }
            }
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
