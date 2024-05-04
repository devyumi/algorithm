package swea.d2;

import java.io.*;

public class No1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 11; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i - 1] - i;
            } else {
                arr[i] = arr[i - 1] + i;
            }
        }

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]);
            if (k != t) {
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
