package boj.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class No11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //풍선 높이만큼 배열 생성
        int[] arr = new int[1000002];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());

            //현재 높이+1에 사용한 화살이 있으면 그 화살을 제거하고 해당 높이에 화살을 추가한다.
            if (arr[h + 1] != 0) {
                arr[h + 1]--;
            }
            arr[h]++;
        }

        for (int i : arr) {
            answer += i;
        }
        System.out.print(answer);
        br.close();
    }
}