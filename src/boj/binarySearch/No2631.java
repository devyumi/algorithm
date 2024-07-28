package boj.binarySearch;

import java.io.*;

public class No2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        int length = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        lis[length++] = arr[0];
        for (int i = 1; i < n; i++) {
            if (lis[length - 1] < arr[i]) {
                lis[length++] = arr[i];
            } else {
                int index = binarySearch(lis, arr[i], length);
                lis[index] = arr[i];
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static int binarySearch(int[] lis, int key, int length) {
        int start = 0;
        int end = length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (lis[mid] == key) {
                return mid;
            } else if (lis[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}