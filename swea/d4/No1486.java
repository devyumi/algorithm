package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1486 {
    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean[] visited;
    private static int sum;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];
            visited = new boolean[n];
            answer = (int) 1e9;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n + 1; i++) {
                sum = 0;
                backTracking(0, 0, i);
            }
            sb.append(answer - m).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void backTracking(int start, int depth, int index) {
        if (depth == index) {
            if (sum >= m) {
                answer = Math.min(answer, sum);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += arr[i];
                backTracking(i + 1, depth + 1, index);
                visited[i] = false;
                sum -= arr[i];
            }
        }
    }
}