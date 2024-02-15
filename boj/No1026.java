package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];
        int[] b = new int[n];
        int[] tmp = new int[n];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            tmp[i] = b[i];
        }

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            int index = binarySearch(tmp, b[i]);
            sum += a[index] * b[index];
        }

        bw.write(String.valueOf(sum));
        bw.close();
    }

    private static int binarySearch(int[] tmp, int key) {
        int start = 0;
        int end = tmp.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (tmp[mid] == key) {
                return mid;
            } else if (tmp[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}
