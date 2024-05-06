package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + br.readLine() + " ");
            int[] arr = new int[101];
            int count = -1;
            int max = -1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }

            for (int i = 0; i < 101; i++) {
                if (arr[i] > count) {
                    count = arr[i];
                    max = i;
                } else if (arr[i] == count) {
                    max = Math.max(max, i);
                }
            }
            sb.append(max + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}