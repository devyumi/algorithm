package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연탄의크기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int div = 2;
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        while (div <= arr[n - 1]) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] % div == 0) {
                    result++;
                }
            }
            div++;
            answer = Math.max(answer, result);
        }
        System.out.print(answer);
        br.close();
    }
}
