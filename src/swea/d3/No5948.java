package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No5948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[7];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 6; j++) {
                    for (int k = j + 1; k < 7; k++) {
                        set.add(arr[i] + arr[j] + arr[k]);
                    }
                }
            }
            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder());
            sb.append(list.get(4) + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}