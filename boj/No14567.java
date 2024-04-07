package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14567 {
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] degree = new int[n + 1];
        answer = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            degree[b]++;
        }

        topology(graph, degree);
        for (int i = 1; i < n + 1; i++) {
            sb.append(answer[i] + " ");
        }
        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.close();
    }

    private static void topology(ArrayList<Integer>[] graph, int[] degree) {
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int now = queue.poll();
                answer[now] = count;
                for (int i : graph[now]) {
                    degree[i]--;
                    if (degree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
            count++;
        }
    }
}