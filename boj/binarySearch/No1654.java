package boj.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        bw.write(String.valueOf(binarySearch(arr, k, n)));
        bw.close();
    }

    private static long binarySearch(int[] arr, int k, int n) {
        long start = 0;
        long end = arr[k - 1];
        long max = Integer.MIN_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i : arr) {
                if (mid != 0) {
                    count += i / mid;
                }
            }

            if (count < n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                max = Math.max(max, mid);
            }
        }
        if (max == Integer.MIN_VALUE) {
            max = 1;
        }
        return max;
    }
}