package boj;

import java.io.*;
import java.util.Arrays;

//완전탐색, 정렬
public class No2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int remainder = 0;
        for (int i : arr) {
            remainder += i;
        }
        remainder -= 100;

        Loop1: for (int i = 0; i < 8; i++) {
            Loop2: for (int j = 1; j < 9; j++) {
                if (arr[i] + arr[j] == remainder) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break Loop1;
                }
            }
        }
        Arrays.sort(arr);
        for (int i = 2; i < 9; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.close();
    }
}