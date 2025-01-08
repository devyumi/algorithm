package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < w - 1; i++) {
            int start = 0;
            int end = 0;

            //arr[i] 기준 왼편에서 가장 큰 수 확인
            for (int j = 0; j < i; j++) {
                start = Math.max(start, arr[j]);
            }

            //arr[i] 기준 오른편에서 가장 큰 수 확인
            for (int j = i + 1; j < w; j++) {
                end = Math.max(end, arr[j]);
            }

            //arr[i]보다 왼쪽, 오른쪽 벽이 높을 때만 물이 고임
            if (arr[i] < start && arr[i] < end) {
                answer += Math.min(start, end) - arr[i];
            }
        }
        System.out.print(answer);
        br.close();
    }
}
