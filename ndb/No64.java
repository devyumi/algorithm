package ndb;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//정렬
public class No64 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int i = 0; i < k; i++) {
            int tmpA = arrA[0];
            int tmpB = arrB[n - 1];

            arrA[0] = tmpB;
            arrB[n - 1] = tmpA;
            Arrays.sort(arrA);
            Arrays.sort(arrB);
        }
        for (int i : arrA) {
            result += i;
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}