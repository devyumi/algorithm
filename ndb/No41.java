package ndb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No41 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = 1;
        int y = 1;

        do {
            char move = st.nextToken().charAt(0);

            if (move == 'L') {
                if (y > 1) {
                    y--;
                }
            } else if (move == 'R') {
                if (y < n) {
                    y++;
                }
            } else if (move == 'U') {
                if (x > 1) {
                    x--;
                }
            } else if (move == 'D') {
                if (x < n) {
                    x++;
                }
            }
        } while (st.hasMoreTokens());

        System.out.print(x + " " + y);
    }
}
