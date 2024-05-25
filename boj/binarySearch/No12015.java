package boj.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class No12015 {
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

    private static int binarySearch(int[] lis, int key, int length) {
        int start = 0;
        while (start <= length) {
            int mid = (start + length) / 2;
            if (lis[mid] == key) {
                return mid;
            } else if (lis[mid] > key) {
                length = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}