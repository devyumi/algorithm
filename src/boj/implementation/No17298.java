package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class No17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        StringBuilder sb = new StringBuilder();
        Arrays.fill(answer, -1);

        //{수열, index}
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        stack.push(new int[]{Integer.parseInt(st.nextToken()), 0});

        for (int i = 1; i < n; i++) {
            int[] num = {Integer.parseInt(st.nextToken()), i};

            while (!stack.isEmpty() && stack.peek()[0] < num[0]) {
                if (answer[stack.peek()[1]] != 1) {
                    answer[stack.peek()[1]] = num[0];
                    stack.pop();
                }
            }
            stack.push(num);
        }

        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}
