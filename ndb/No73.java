package ndb;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//이진탐색
public class No73 {
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

        bw.write(String.valueOf(binarySearch(arr, m, 0, arr[n - 1])));
        bw.close();
    }

    private static int binarySearch(int[] arr, int key, int start, int end) {
        int result = 0;
        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;

            for (int i : arr) {
                if (i > mid) {
                    sum += i - mid;
                }
            }

            if (sum < key) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}