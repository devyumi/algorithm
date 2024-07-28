package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6730 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int maxUp = 0;
            int maxDown = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    maxUp = Math.max(maxUp, arr[i + 1] - arr[i]);
                } else if (arr[i] > arr[i + 1]) {
                    maxDown = Math.max(maxDown, arr[i] - arr[i + 1]);
                } else if (arr[i] == arr[i + 1]) {
                    maxUp = Math.max(maxUp, arr[i + 1] - arr[i]);
                    maxDown = Math.max(maxDown, arr[i] - arr[i + 1]);
                }
            }
            sb.append("#").append(t).append(" ").append(maxUp).append(" ").append(maxDown).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}