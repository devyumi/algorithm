package boj;

import java.io.*;
import java.util.StringTokenizer;

public class No1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int answer = 100000001;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        while (true) {
            if (sum >= s) {
                answer = Math.min(answer, end - start);
                sum -= arr[start++];
            } else if (end == n) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        if (answer == 100000001) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(answer));
        }
        bw.close();
    }
}