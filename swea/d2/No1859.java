package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1859 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = (Integer.parseInt(st.nextToken()));
            }

            long max = 0;
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                sum += max - arr[i];
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}