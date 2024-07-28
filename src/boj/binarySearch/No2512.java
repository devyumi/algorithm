package boj.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int tmpSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmpSum += arr[i];
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        if (m >= tmpSum) {
            bw.write(String.valueOf(arr[n - 1]));
        } else {
            bw.write(String.valueOf(binarySearch(arr, n, m)));
        }
        bw.close();
    }

    private static int binarySearch(int[] arr, int n, int m) {
        int start = 0;
        int end = arr[n - 1];
        long min = Integer.MAX_VALUE;
        int result = 0;

        while (start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;

            for (int i : arr) {
                if (mid >= i) {
                    sum += i;
                } else {
                    sum += mid;
                }
            }

            if (m - sum >= 0) {
                start = mid + 1;
                if (min > m - sum) {
                    min = m - sum;
                    result = mid;
                }
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}