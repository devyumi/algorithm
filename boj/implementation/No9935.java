package boj.implementation;

import java.io.*;
import java.util.Stack;

public class No9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();
        String boobString = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            stack.push(c);
            int length = boobString.length();
            if (c == boobString.charAt(length - 1) && stack.size() >= length) {
                StringBuilder sb = new StringBuilder();
                while (length-- > 0) {
                    sb.append(stack.pop());
                }

                if (!sb.reverse().toString().equals(boobString.toString())) {
                    for (char ch : sb.toString().toCharArray()) {
                        stack.push(ch);
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            bw.write(sb.toString());
        }
        bw.close();
    }
}