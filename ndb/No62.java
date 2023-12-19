package ndb;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

//정렬
public class No62 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i : arr) {
            bw.write(String.valueOf(i) + " ");
        }
        bw.close();
    }
}
