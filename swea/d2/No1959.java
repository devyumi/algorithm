package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1959 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[a];
            int[] arr2 = new int[b];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            if (arr1.length <= arr2.length) {
                sb.append(maxSum(arr1, arr2)).append("\n");
            } else {
                sb.append(maxSum(arr2, arr1)).append("\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int maxSum(int[] arr1, int[] arr2) {
        int max = 0;
        int start = 0;
        int end = arr1.length - 1;

        while (end < arr2.length) {
            int sum = 0;

            for (int i = 0; i < arr1.length; i++) {
                sum += arr1[i] * arr2[start++];
            }
            max = Math.max(max, sum);
            start = end - arr1.length + 2;
            end++;
        }
        return max;
    }
}