package boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15652 {
    private static int n;
    private static int m;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        backTracking(0);
        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }

    private static void backTracking(int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (depth > 0) {
                if (arr[depth - 1] > i) {
                    continue;
                } else {
                    arr[depth] = i;
                }
            } else {
                arr[depth] = i;
            }
            backTracking(depth + 1);
        }
    }
}