package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1873 {
    private static int h;
    private static int w;
    private static char[][] map;
    private static int x;
    private static int y;
    private static int direction;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            for (int i = 0; i < h; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = tmp[j];
                    switch (map[i][j]) {
                        case '<':
                            x = i;
                            y = j;
                            direction = 2;
                            map[i][j] = '.';
                            break;

                        case '>':
                            x = i;
                            y = j;
                            direction = 3;
                            map[i][j] = '.';
                            break;

                        case '^':
                            x = i;
                            y = j;
                            direction = 0;
                            map[i][j] = '.';
                            break;

                        case 'v':
                            x = i;
                            y = j;
                            direction = 1;
                            map[i][j] = '.';
                            break;
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());
            char[] commands = br.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                char command = commands[i];
                switch (command) {
                    case 'U':
                        up();
                        break;
                    case 'D':
                        down();
                        break;
                    case 'L':
                        left();
                        break;
                    case 'R':
                        right();
                        break;
                    case 'S':
                        shoot();
                        break;
                }
            }
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (i == x && j == y) {
                        switch (direction) {
                            case 0:
                                sb.append('^');
                                break;
                            case 1:
                                sb.append('v');
                                break;
                            case 2:
                                sb.append('<');
                                break;
                            case 3:
                                sb.append('>');
                                break;
                        }
                    } else {
                        sb.append(map[i][j]);
                    }
                }
                if (i != h - 1) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void up() {
        direction = 0;
        int tmpX = x + dx[direction];
        int tmpY = y + dy[direction];

        if (tmpX >= 0 && tmpX < h && tmpY >= 0 && tmpY < w && map[tmpX][tmpY] == '.') {
            x = tmpX;
            y = tmpY;
        }
    }

    private static void down() {
        direction = 1;
        int tmpX = x + dx[direction];
        int tmpY = y + dy[direction];

        if (tmpX >= 0 && tmpX < h && tmpY >= 0 && tmpY < w && map[tmpX][tmpY] == '.') {
            x = tmpX;
            y = tmpY;
        }
    }

    private static void left() {
        direction = 2;
        int tmpX = x + dx[direction];
        int tmpY = y + dy[direction];

        if (tmpX >= 0 && tmpX < h && tmpY >= 0 && tmpY < w && map[tmpX][tmpY] == '.') {
            x = tmpX;
            y = tmpY;
        }
    }

    private static void right() {
        direction = 3;
        int tmpX = x + dx[direction];
        int tmpY = y + dy[direction];

        if (tmpX >= 0 && tmpX < h && tmpY >= 0 && tmpY < w && map[tmpX][tmpY] == '.') {
            x = tmpX;
            y = tmpY;
        }
    }

    private static void shoot() {
        int shootX = x + dx[direction];
        int shootY = y + dy[direction];

        while (true) {
            if (shootX < 0 || shootX >= h || shootY < 0 || shootY >= w) {
                break;
            } else if (map[shootX][shootY] == '#') {
                break;
            } else if (map[shootX][shootY] == '*') {
                map[shootX][shootY] = '.';
                break;
            }
            shootX += dx[direction];
            shootY += dy[direction];
        }
    }
}