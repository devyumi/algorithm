package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //절댓값이 큰 수를 한 번에 가져가야 함으로 내림차순
        PriorityQueue<Integer> plus = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minus = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int max = 0;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.abs(tmp));
            if (tmp > 0) {
                plus.offer(tmp);
                continue;
            }
            minus.offer(Math.abs(tmp));
        }

        while (!plus.isEmpty()) {
            answer += plus.peek() * 2;
            for (int i = 0; i < m; i++) {
                plus.poll();
            }
        }

        while (!minus.isEmpty()) {
            answer += minus.peek() * 2;
            for (int i = 0; i < m; i++) {
                minus.poll();
            }
        }
        //다시 0으로 돌아올 필요가 없으므로 max(==가장 마지막으로 책을 두는 위치)값을 뺀다.
        System.out.print(answer - max);
        br.close();
    }
}
