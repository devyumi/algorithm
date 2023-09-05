package ndb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No33 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        int[] min = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            min[i] = arr[0];
            for (int j = 1; j < m; j++) {
                if (min[i] > arr[j]) {
                    min[i] = arr[j];
                }
            }
            if (max < min[i]) {
                max = min[i];
            }
        }
        System.out.print(max);
    }
}