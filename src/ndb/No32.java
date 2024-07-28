package ndb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No32 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int max1 = arr[n - 1];
        int max2 = arr[n - 2];
        int result = 0;

        Loop1:
        while (m != 0) {
            Loop2:
            for (int i = 0; i < k; i++) {
                if (m == 0) {
                    break Loop1;
                }
                result += max1;
                m--;
            }
            if (m == 0) {
                break Loop1;
            }
            result += max2;
            m--;
        }
        System.out.print(result);
    }
}
