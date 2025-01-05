package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1325 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[n];
        int[] hacking = new int[n];

        for (int i = 1; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        //bfs 알고리즘을 메서드로 정의하면 시간 초과가 발생한다..
        for (int i = 1; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            visited[i] = true;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int next : list[now]) {
                    if (!visited[next]) {
                        hacking[next]++;
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        //가장 많이 연결된 컴퓨터 대수 추출
        int max = Arrays.stream(hacking).max().getAsInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++) {
            if (hacking[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}
