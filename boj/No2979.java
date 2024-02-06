package boj;

import java.io.*;
import java.util.StringTokenizer;

public class No2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[101];
        int result = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x + 1; j <= y; j++) {
                arr[j]++;
            }
        }

        for (int i = 1; i < 101; i++) {
            if (arr[i] == 1) {
                result += a;
            } else if (arr[i] == 2) {
                result += b * 2;
            } else if (arr[i] == 3) {
                result += c * 3;
            }
        }
        
        bw.write(String.valueOf(result));
        bw.close();
    }
}