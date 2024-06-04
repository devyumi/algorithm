package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[100001];
        bw.write(String.valueOf(bfs(arr, n, k)));
        bw.close();
    }

    private static int bfs(int[] arr, int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == k) {
                break;
            }

            if (now - 1 >= 0 && now - 1 < 100001 && arr[now - 1] == 0) {
                arr[now - 1] = arr[now] + 1;
                queue.offer(now - 1);
            }
            if (now + 1 >= 0 && now + 1 < 100001 && arr[now + 1] == 0) {
                arr[now + 1] = arr[now] + 1;
                queue.offer(now + 1);
            }
            if (now * 2 >= 0 && now * 2 < 100001 && arr[now * 2] == 0) {
                arr[now * 2] = arr[now] + 1;
                queue.offer(now * 2);
            }
        }
        return arr[k];
    }
}