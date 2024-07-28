package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            sb.append("#" + t + " ");
            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            Loop1:
            while (true) {
                for (int i = 1; i <= 5; i++) {
                    int n = queue.poll();
                    if (n - i >= 1) {
                        queue.offer(n - i);
                    } else {
                        queue.offer(0);
                        break Loop1;
                    }
                }
            }

            for (int i : queue) {
                sb.append(i + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}