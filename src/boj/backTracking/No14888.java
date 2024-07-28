package boj.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class No14888 {
    private static int n;
    private static int[] arr;
    private static int[] operation;
    private static int max;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        operation = new int[4];
        max = -(int) 1e9;
        min = (int) 1e9;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(arr[0], 1);
        bw.write(max + "\n" + min);
        bw.close();
    }

    private static void backTracking(int result, int depth) {
        if (depth == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;

                if (i == 0) {
                    backTracking(result + arr[depth], depth + 1);
                } else if (i == 1) {
                    backTracking(result - arr[depth], depth + 1);
                } else if (i == 2) {
                    backTracking(result * arr[depth], depth + 1);
                } else if (i == 3) {
                    backTracking(result / arr[depth], depth + 1);
                }
                operation[i]++;
            }
        }
    }
}