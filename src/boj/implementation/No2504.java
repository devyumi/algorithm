package boj.implementation;

import java.io.*;
import java.util.Stack;

public class No2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] strings = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int weight = 1;
        int answer = 0;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == '(') {
                stack.push('(');
                weight *= 2;
            } else if (strings[i] == '[') {
                stack.push('[');
                weight *= 3;
            } else if (strings[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    if (strings[i - 1] == '(') {
                        answer += weight;
                    }
                    stack.pop();
                    weight /= 2;
                } else {
                    answer = 0;
                    break;
                }
            } else if (strings[i] == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    if (strings[i - 1] == '[') {
                        answer += weight;
                    }
                    stack.pop();
                    weight /= 3;
                } else {
                    answer = 0;
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            bw.write(String.valueOf(answer));
        } else {
            bw.write("0");
        }
        bw.close();
        br.close();
    }
}