package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2817 {
    private static int n;
    private static int k;
    private static int[] arr;
    private static boolean[] visited;
    private static int sum;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n];
            visited = new boolean[n];
            answer = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            for (int i = 1; i <= n; i++) {
                sum = 0;
                backTracking(0, 0, i);
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void backTracking(int start, int depth, int index) {
        if (depth == index) {
            if (sum == k) {
                answer++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (arr[i] <= k) {
                visited[i] = true;
                sum += arr[i];
                backTracking(i + 1, depth + 1, index);
                visited[i] = false;
                sum -= arr[i];
            }
        }
    }
}