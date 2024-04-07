package boj;

import java.io.*;
import java.util.*;

public class No2056 {
    private static int[] time;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] degree = new int[n + 1];
        time = new int[n + 1];
        answer = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            answer[i] = time[i];
            int tmp = Integer.parseInt(st.nextToken());
            degree[i] = tmp;
            while (tmp-- > 0) {
                int index = Integer.parseInt(st.nextToken());
                graph[index].add(i);
            }
        }

        topology(graph, degree);
        bw.write(String.valueOf(Arrays.stream(answer).max().getAsInt()));
        bw.close();
    }

    private static void topology(ArrayList<Integer>[] graph, int[] degree) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : graph[now]) {
                degree[i]--;
                if (degree[i] == 0) {
                    queue.offer(i);
                }
                answer[i] = Math.max(answer[i], time[i] + answer[now]);
            }
        }
    }
}