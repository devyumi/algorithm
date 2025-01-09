package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//0-1BFS 학습 후 다시 시도
public class No13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        System.out.print(bfs(n, k, visited));
        br.close();
    }

    private static int bfs(int n, int k, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        visited[n] = true;
        int answer = 0;

        //new int[]{위치 N, 초}
        queue.offer(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == k) {
                answer = now[1];
                break;
            }

            if (now[0] - 1 >= 0 && !(visited[now[0] - 1])) {
                queue.offer(new int[]{now[0] - 1, now[1] + 1});
                visited[now[0] - 1] = true;
            }
            if (now[0] + 1 <= 100000 && !(visited[now[0] + 1])) {
                queue.offer(new int[]{now[0] + 1, now[1] + 1});
                visited[now[0] + 1] = true;
            }
            if (now[0] * 2 <= 100000 && !(visited[now[0] * 2])) {
                queue.offer(new int[]{now[0] * 2, now[1]});
                visited[now[0] * 2] = true;
            }
        }
        return answer;
    }
}
