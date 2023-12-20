package ndb;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//이진탐색
public class No73 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] raceCake = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            raceCake[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(raceCake);

        for (int i = raceCake[0]; i < raceCake[n - 1]; i++) {
            int length = 0;
            for (int j = 0; j < n; j++) {
                if (i <= raceCake[j]) {
                    length += (raceCake[j] - i);
                }
            }
            if (length == m) {
                result = i;
                break;
            }
            if (length > m) {
                length = 0;
                continue;
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
