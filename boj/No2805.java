package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// binary Search, type long
public class No2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result = binarySearch(arr, n, m);

        bw.write(String.valueOf(result));
        bw.close();
    }

    private static int binarySearch(int[] arr, int n, int m) {
        int start = 0;
        int end = arr[n - 1];

        while (start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;

            for (int i : arr) {
                if (i > mid) {
                    sum += i - mid;
                }
            }

            if (sum >= m) {
                start = mid + 1;
            } else if (sum < m) {
                end = mid - 1;
            }
        }
        return end;
    }
}