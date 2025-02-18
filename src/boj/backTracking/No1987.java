package boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1987 {
    private static int r;
    private static int c;
    private static char[][] arr;
    private static boolean[] alphabet;
    private static int answer;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        arr = new char[r][c];
        alphabet = new boolean[26];
        answer = 1;

        for (int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = chars[j];
            }
        }

        alphabet[arr[0][0] - 65] = true;
        backTracking(0, 0);
        System.out.print(answer);
        br.close();
    }

    private static void backTracking(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || alphabet[arr[nx][ny] - 65]) {
                continue;
            }

            alphabet[arr[nx][ny] - 65] = true;
            backTracking(nx, ny);

            //현재 위치까지 새로 지난 알파벳 최대 값 계산
            answer = Math.max(answer, trueSum());
            alphabet[arr[nx][ny] - 65] = false;
        }
    }

    private static int trueSum() {
        int result = 0;
        for (Boolean b : alphabet) {
            if (b) {
                result++;
            }
        }
        return result;
    }
}