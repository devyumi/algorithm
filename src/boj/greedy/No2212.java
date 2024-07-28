package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sensor = new int[n - 1];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n <= k) {
            bw.write("0");
        } else {
            Arrays.sort(arr);

            for (int i = 0; i < n - 1; i++) {
                sensor[i] = arr[i + 1] - arr[i];
            }

            Arrays.sort(sensor);
            for (int i = 0; i < n - k; i++) {
                result += sensor[i];
            }
            bw.write(String.valueOf(result));
        }
        bw.close();
    }
}