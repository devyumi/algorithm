package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//구현
public class No9202 {
    private static int w;
    private static ArrayList<Dictionary> dictionaries;
    private static int score;
    private static String longWord;
    private static int findWords;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        w = Integer.parseInt(br.readLine());
        dictionaries = new ArrayList<>();

        for (int i = 0; i < w; i++) {
            dictionaries.add(new Dictionary(br.readLine(), 0));
        }

        br.readLine();
        int b = Integer.parseInt(br.readLine());

        for (int k = 0; k < b; k++) {
            String[][] board = new String[4][4];
            score = 0;
            longWord = "";
            findWords = 0;

            for (int i = 0; i < 4; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < 4; j++) {
                    board[i][j] = str[j];
                }
            }

            if (k < b - 1) {
                br.readLine();
            }

            for (int i = 0; i < w; i++) {
                dictionaries.get(i).using = 0;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    bfs(board, i, j);
                }
            }
            bw.write(score + " " + longWord + " " + findWords + "\n");
        }
        bw.close();
    }

    private static void bfs(String[][] board, int x, int y) {
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        int dictionaryNumber = -1;
        int wordsIndex = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < w; i++) {
            if (board[x][y].equals(String.valueOf(dictionaries.get(i).words.charAt(0)))) {
                dictionaryNumber = i;
            }
        }

        if (dictionaryNumber == -1) {
            return;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        sb.append(board[x][y]);

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 8; i++) {
                if (sb.length() == dictionaries.get(dictionaryNumber).words.length()) {
                    if (dictionaries.get(dictionaryNumber).using == 0) {
                        dictionaries.get(dictionaryNumber).using = 1;
                        findWords++;
                    } else {
                        return;
                    }

                    switch (sb.length()) {
                        case 3:
                            score += 1;
                            break;
                        case 4:
                            score += 1;
                            break;
                        case 5:
                            score += 2;
                            break;
                        case 6:
                            score += 3;
                            break;
                        case 7:
                            score += 5;
                            break;
                        case 8:
                            score += 11;
                            break;
                    }

                    if (sb.length() > longWord.length()) {
                        longWord = dictionaries.get(dictionaryNumber).words;
                    } else if (sb.length() == longWord.length()) {
                        if (sb.charAt(0) < longWord.charAt(0)) {
                            longWord = sb.toString();
                        }
                    }
                    return;
                }

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {

                    if (board[nx][ny].equals(String.valueOf(dictionaries.get(dictionaryNumber).words.charAt(wordsIndex)))) {
                        sb.append(board[ny][ny]);
                        wordsIndex++;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private static class Dictionary {
        private String words;
        private int using;

        public Dictionary(String words, int using) {
            this.words = words;
            this.using = using;
        }
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}