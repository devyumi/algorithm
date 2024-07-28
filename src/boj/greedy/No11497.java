package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] arr2 = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int start = 0;
            int end = n;
            boolean isStartFill = false;

            for (int i = 0; i < n; i++) {
                if (!isStartFill) {
                    arr2[start] = arr[i];
                    end--;
                    isStartFill = true;
                } else {
                    arr2[end] = arr[i];
                    start++;
                    isStartFill = false;
                }
            }

            int min = Math.abs(arr2[0] - arr2[n - 1]);
            for (int i = 1; i < n; i++) {
                min = Math.max(min, Math.abs(arr2[i] - arr2[i - 1]));
            }
            sb.append(min).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}