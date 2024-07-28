package boj.implementation;

import java.io.*;

public class No10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        int size = 0;
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                size++;
            } else {
                size--;
                if (arr[i - 1] == '(') {
                    answer += size;
                } else {
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
