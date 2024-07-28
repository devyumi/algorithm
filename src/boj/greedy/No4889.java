package boj.greedy;

import java.io.*;
import java.util.Stack;

public class No4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int number = 0;

        while (true) {
            str = br.readLine();
            if (str.contains("-")) {
                break;
            }
            int result = 0;
            char[] arr = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (arr[i] == '{') {
                    stack.push('{');
                } else {
                    if (stack.isEmpty()) {
                        result++;
                        stack.push('{');
                    } else {
                        stack.pop();
                    }
                }
            }
            result += stack.size() / 2;
            number++;
            bw.write(number + ". " + result + "\n");
        }
        bw.close();
    }
}