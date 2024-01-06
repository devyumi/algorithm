package ndb;

import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split("");
        int[] arr = new int[str.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int result = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (result <= 1 || arr[i + 1] <= 1) {
                result += arr[i + 1];
            } else {
                result *= arr[i + 1];
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
