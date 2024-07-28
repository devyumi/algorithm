package programmers.lv1;

import java.util.StringTokenizer;

public class 공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        answer = new int[2];

        final int[] dx = {-1, 1, 0, 0};
        final int[] dy = {0, 0, -1, 1};
        int x = 0;
        int y = 0;

        Loop:
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break Loop;
                }
            }
        }

        for (String s : routes) {
            StringTokenizer st = new StringTokenizer(s);
            String op = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int d = opToInteger(op);
            boolean possibility = true;

            int nx = x;
            int ny = y;

            for (int i = 0; i < cnt; i++) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length() || park[nx].charAt(ny) == 'X') {
                    possibility = false;
                    break;
                }
            }

            if (possibility) {
                x = nx;
                y = ny;
            }
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    private static int opToInteger(String op) {
        int direction = 0;
        switch (op) {
            case "S":
                direction = 1;
                break;
            case "W":
                direction = 2;
                break;
            case "E":
                direction = 3;
                break;
        }
        return direction;
    }
}
