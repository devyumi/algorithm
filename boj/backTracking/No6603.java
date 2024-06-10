package boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6603 {
    private static int k;
    private static int[] arr;
    private static int[] result;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            arr = new int[k];
            result = new int[6];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backTracking(0, 0);
            sb.append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void backTracking(int start, int depth) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            result[depth] = arr[i];
            backTracking(i + 1, depth + 1);
        }
    }
}