package boj.backTracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1759 {
    private static int l;
    private static int c;
    private static BufferedWriter bw;
    private static Character[] arr;
    private static Character[] password;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new Character[c];
        password = new Character[l];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        backTracking(0, 0);
        bw.close();
    }

    private static void backTracking(int depth, int start) throws IOException {
        if (depth == l) {
            if (checkPassword(password)) {
                for (Character c : password) {
                    bw.write(c);
                }
                bw.newLine();
            }
            return;
        }

        for (int i = start; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                password[depth] = arr[i];
                backTracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean checkPassword(Character[] password) {
        int j = 0;
        int m = 0;

        for (Character c : password) {
            if (c.equals('a') || c.equals('e') || c.equals('i') || c.equals('o') || c.equals('u')) {
                m++;
            } else {
                j++;
            }
        }
        if (m >= 1 && j >= 2) {
            return true;
        } else {
            return false;
        }
    }
}