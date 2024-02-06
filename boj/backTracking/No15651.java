package boj.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class No15651 {
    private static int n;
    private static int m;
    private static int[] arr;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        backTracking(0);
        bw.close();
    }

    private static void backTracking(int depth) throws IOException {
        if (depth == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            arr[depth] = i;
            backTracking(depth + 1);
        }
    }
}