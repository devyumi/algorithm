package ndb;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//위상정렬
public class No104 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] degree = new int[n + 1];
        int[] time = new int[n + 1];
        int[] result = new int[n + 1];

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            result[i] = time[i];

            int tmp = 0;
            while (tmp != -1) {
                tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) {
                    break;
                }
                graph[tmp].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : graph[now]) {
                result[i] = Math.max(result[i], result[now] + time[i]);
                degree[i]--;
                if (degree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            bw.write(result[i] + " ");
        }
        bw.close();
    }
}