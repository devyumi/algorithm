package boj;

import java.io.*;
import java.util.Stack;

//구현, stack
public class No9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] str;
        Stack<String> stack;

        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            str = br.readLine().split("");

            for (String s : str) {
                if (s.equals("(")) {
                    stack.push(s);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(s);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.close();
    }
}