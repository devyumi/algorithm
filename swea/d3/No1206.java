package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#" + tc + " ");
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i < n - 2; i++) {
                int height = (int) 1e9;
                height = Math.min(height, arr[i] - arr[i - 2]);
                height = Math.min(height, arr[i] - arr[i - 1]);
                height = Math.min(height, arr[i] - arr[i + 1]);
                height = Math.min(height, arr[i] - arr[i + 2]);
                if (height > 0) {
                    answer += height;
                }
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}