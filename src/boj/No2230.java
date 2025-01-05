package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2230 {
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        //M(20억) 이상의 가장 작은 차이를 출력해야 함으로 20억 이상으로 설정
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //정렬 후 투포인터
        Arrays.sort(arr);
        twoPointer(arr, m);

        System.out.print(answer);
        br.close();
    }

    private static void twoPointer(int[] arr, int m) {
        int start = 0;
        int end = start + 1;

        while (end < arr.length && start <= end) {
            int tmp = arr[end] - arr[start];

            if (tmp == m) {
                answer = tmp;
                break;
            } else if (tmp < m) {
                end++;
            } else {
                answer = Math.min(answer, tmp);
                start++;
            }
        }
    }
}