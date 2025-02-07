package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        //강의 가는 날 (max 10000일)
        boolean[] visited = new boolean[10001];

        //페이가 높을수록, 남은 강연 일자가 많을수록 유리하다.
        PriorityQueue<Schedule> pQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.p == o2.p) {
                return o2.d - o1.d;
            }
            return o2.p - o1.p;
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pQ.offer(new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!pQ.isEmpty()) {
            Schedule sc = pQ.poll();

            //d일 안에 와야되므로 그 전 날까지 강의를 가야한다.
            for (int i = sc.d - 1; i >= 0; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer += sc.p;
                    break;
                }
            }
        }
        System.out.print(answer);
        br.close();
    }

    private static class Schedule {
        private int p;
        private int d;

        public Schedule(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}
