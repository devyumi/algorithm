package boj.dp;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (Comparator.comparingInt(o -> o[0])));

        int length = 0;
        dp[length++] = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][1] > dp[length - 1]) {
                dp[length++] = arr[i][1];
            } else {
                int index = binarySearch(dp, arr[i][1], length);
                dp[index] = arr[i][1];
            }
        }
        bw.write(String.valueOf(n - length));
        bw.close();
    }

    private static int binarySearch(int[] dp, int key, int length) {
        int start = 0;
        while (start <= length) {
            int mid = (start + length) / 2;
            if (dp[mid] == key) {
                return mid;
            } else if (dp[mid] < key) {
                start = mid + 1;
            } else {
                length = mid - 1;
            }
        }
        return start;
    }
}