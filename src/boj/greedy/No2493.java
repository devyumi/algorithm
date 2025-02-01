package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //탑 index, 탑 높이
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());

            //비어 있으면 받을 건물이 없으니 0 출력
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(new int[]{i, height});
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append(0).append(" ");
                        stack.push(new int[]{i, height});
                        break;
                    }

                    //기존 건물보다 높이가 크면 레이저를 보낼 곳이 없다.
                    if (stack.peek()[1] < height) {
                        stack.pop();
                    }
                    //기존 건물보다 높이가 작으면 레이저를 보낼 수 있다.
                    else {
                        sb.append(stack.peek()[0]).append(" ");
                        stack.push(new int[]{i, height});
                        break;
                    }
                }
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}
