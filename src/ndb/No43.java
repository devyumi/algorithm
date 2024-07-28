package ndb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No43 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int x = s.charAt(1) - 48;
        int y = s.charAt(0) - 96;
        int[][] moves = {{-1, 2}, {1, 2}, {2, 1}, {2, -1}, {-1, -2}, {1, -2}, {-2, -1}, {-2, 1}};
        int result = 0;

        for (int[] move : moves) {
            if (x + move[0] > 0 && x + move[0] < 9 && y + move[1] > 0 && y + move[1] < 9) {
                result++;
            }
        }
        System.out.print(result);
    }
}
