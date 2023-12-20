package ndb;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//이진탐색 Arrays.binarySearch()
public class No72 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) < 0) {
                bw.write("no ");
            } else
                bw.write("yes ");
        }
        bw.close();
    }
}