package ndb;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//dp
public class No85 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        dp[1] = m / arr[0];
        m %= arr[0];
        for (int i = 2; i < n + 1; i++) {
            if (m == 0) {
                break;
            }
            dp[i] = dp[i - 1] + m / arr[i - 1];
            m %= arr[i - 1];
        }

        if (m == 0) {
            bw.write(String.valueOf(Arrays.stream(dp).max().getAsInt()));
        } else {
            bw.write("-1");
        }
        bw.close();
    }
}
