package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        StringBuilder sb = new StringBuilder();

        //{높이, index}
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        stack.push(new int[]{Integer.parseInt(st.nextToken()), 0});

        for (int i = 1; i < n; i++) {
            int[] tmp = {Integer.parseInt(st.nextToken()), i};

            if (!stack.isEmpty()) {
                if (stack.peek()[0] > tmp[0]) {
                    answer[tmp[1]] = stack.peek()[1] + 1;
                } else {
                    while (!stack.isEmpty()) {
                        if (stack.peek()[0] > tmp[0]) {
                            answer[tmp[1]] = stack.peek()[1] + 1;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
                stack.push(tmp);
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}
