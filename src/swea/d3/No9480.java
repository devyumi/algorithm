package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9480 {
    private static int n;
    private static String[] words;
    private static boolean[] visited;
    private static StringBuilder wordsCombination;
    private static int wordsSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            n = Integer.parseInt(br.readLine());
            words = new String[n];
            wordsSet = 0;
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }

            for (int i = 1; i <= n; i++) {
                visited = new boolean[n];
                wordsCombination = new StringBuilder();
                backTracking(0, 0, i);
            }
            sb.append(wordsSet + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void backTracking(int start, int depth, int index) {
        if (depth == index) {
            int[] alphabet = new int[26];
            char[] resultChar = wordsCombination.toString().toCharArray();

            for (char c : resultChar) {
                alphabet[(int) c - 97] = 1;

            }

            for (int i : alphabet) {
                if (i == 0) {
                    return;
                }
            }
            wordsSet++;
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int length = wordsCombination.length();
                wordsCombination.append(words[i]);
                backTracking(i + 1, depth + 1, index);
                visited[i] = false;
                wordsCombination.delete(length, wordsCombination.length());
            }
        }
    }
}