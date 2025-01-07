package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = start + 1;
        int tmp = 0;

        while (end <= w - 1) {
            //
            if (arr[start] > arr[end] && end == w - 1 && arr[end] != 0) {
                answer += tmp - ((arr[start] - arr[end]) * (end - start));
                break;

            } else if (arr[start] > arr[end]) {
                tmp += arr[start] - arr[end++];
            }

            else if (arr[start] <= arr[end]) {
                answer += tmp;
                tmp = 0;
                start = end++;
            }
        }
        System.out.print(answer);
        br.close();
    }
}
