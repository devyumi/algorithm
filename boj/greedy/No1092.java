package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        Integer[] box = new Integer[m];
        boolean[] visited = new boolean[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());

        if (crane[0] < box[0]) {
            bw.write("-1");
        } else {
            int index = 0;
            while (m > 0) {
                for (int i = 0; i < box.length; i++) {
                    if (index == n) {
                        break;
                    }

                    if (crane[index] >= box[i] && !visited[i]) {
                        index++;
                        visited[i] = true;
                        m--;
                    }
                }
                index = 0;
                result++;
            }
            bw.write(String.valueOf(result));
        }
        bw.close();
    }
}