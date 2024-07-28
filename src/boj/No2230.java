package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = start + 1;
        while (end < arr.length && start <= end) {
            int tmp = arr[end] - arr[start];
            if (tmp == m) {
                answer = tmp;
                break;
            } else if (tmp < m) {
                end++;
            } else {
                answer = Math.min(answer, tmp);
                start++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}