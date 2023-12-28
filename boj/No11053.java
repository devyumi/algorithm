package boj;

import java.io.*;
import java.util.StringTokenizer;

public class No11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        int length = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[length++] = arr[0];
        for (int i = 1; i < n; i++) {
            if (lis[length - 1] < arr[i]) {
                lis[length++] = arr[i];
            } else {
                int index = binarySearch(lis, arr[i], length);
                lis[index] = arr[i];
            }
        }
        bw.write(String.valueOf(length));
        bw.close();
    }

    private static int binarySearch(int[] lis, int key, int end) {
        int start = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            if (lis[mid] >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}