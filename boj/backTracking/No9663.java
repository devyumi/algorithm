package boj.backTracking;

import java.io.*;

public class No9663 {
    private static int n;
    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        answer = 0;

        backTracking(0);
        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static void backTracking(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (check(depth)) {
                backTracking(depth + 1);
            }
        }
    }

    private static boolean check(int depth) {
        for (int j = 0; j < depth; j++) {
            if (arr[depth] == arr[j] || Math.abs(depth - j) == Math.abs(arr[depth] - arr[j])) {
                return false;
            }
        }
        return true;
    }
}