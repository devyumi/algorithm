package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(twoPointer(arr));
        br.close();
    }

    private static int twoPointer(int[] arr) {
        Arrays.sort(arr);
        int answer = 0;

        //타겟 설정
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            int end = arr.length - 1;

            //투포인터 시작
            while (start < end) {
                int sum = arr[start] + arr[end];

                if (sum == arr[i]) {
                    //다른 수 두 개의 합: 서로 다른 수가 아닌 자기 자신만 제외하면 된다는 뜻이었다..
                    if (start != i && end != i) {
                        answer++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }

                } else if (sum < arr[i]) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return answer;
    }
}
