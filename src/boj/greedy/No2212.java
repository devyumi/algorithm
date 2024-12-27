package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        //집중국이 센서 개수보다 적을 때 계산
        if (n <= k) {
            System.out.print(0);
        } else {
            int[] arr = new int[n];
            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1] - arr[i];
            }

            //최대값 1000000 이상 값 저장 (사용하지 않는 값)
            arr[n - 1] = 1000001;

            //배열 차 저장 후 다시 정렬
            Arrays.sort(arr);

            for (int i = 0; i < n - k; i++) {
                answer += arr[i];
            }
            System.out.print(answer);
        }
        br.close();
    }
}