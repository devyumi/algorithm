package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//dp
public class No15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<schedule> list = new ArrayList<>();
        int[] dp = new int[n + 2];
        int max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            list.add(new schedule(time, price));
        }

        for (int i = 1; i < n + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int day = i + list.get(i - 1).time;
            if (day <= n + 1) {
                dp[day] = Math.max(dp[day], max + list.get(i - 1).price);
            }
        }

        bw.write(String.valueOf(Arrays.stream(dp).max().getAsInt()));
        bw.close();
    }

    private static class schedule {
        private int time;
        private int price;

        public schedule(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }
}