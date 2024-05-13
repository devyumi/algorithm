package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1219 {
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("#" + st.nextToken() + " ");
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] list = new ArrayList[100];
            answer = 0;

            for (int i = 0; i < 100; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
            }
            dfs(list, 0);
            sb.append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static void dfs(ArrayList<Integer>[] list, int start) {
        for (int i : list[start]) {
            if (i == 99) {
                answer = 1;
                return;
            }
            dfs(list, i);
        }
    }
}