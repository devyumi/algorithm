package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        long sum = 0;
        long personByDistance = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            sum += arr[i][1];
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            personByDistance += arr[i][1];

            //중간값 계산 (마을 기준 좌우의 사람 수가 균일해야 함)
            if ((sum + 1) / 2 <= personByDistance) {
                System.out.print(arr[i][0]);
                break;
            }
        }
        br.close();
    }
}
