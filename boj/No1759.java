package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//backTracking
public class No1759 {
    private static int l;
    private static int c;
    private static String[] arr;
    private static String[] result;
    private static boolean[] visited;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[c];
        result = new String[l];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);
        backTracking(0, 0);
        bw.close();
    }

    private static void backTracking(int start, int depth) throws IOException {
        if (depth == l) {
            if (checkPassword(result)) {
                for (String s : result) {
                    bw.write(s);
                }
                bw.newLine();
            }
            return;
        }
        for (int i = start; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backTracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean checkPassword(String[] str) {
        int m = 0;
        int j = 0;

        for (String s : str) {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                m++;
            } else {
                j++;
            }
        }
        if (m >= 1 && j >= 2) {
            return true;
        }
        return false;
    }
}