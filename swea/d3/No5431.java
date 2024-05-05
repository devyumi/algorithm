package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int l = 1; l <= t; l++) {
            sb.append("#" + l + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < k; i++) {
                visited[Integer.parseInt(st.nextToken())] = true;
            }

            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    sb.append(i + " ");
                }
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}