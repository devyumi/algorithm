package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No6719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            double a = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);
            for (int i = 0; i < n - k; i++) {
                list.remove(0);
            }

            for (int i = 0; i < list.size(); i++) {
                a = (a + list.get(i)) / 2.0;
            }
            sb.append(String.format("%.6f\n", a));
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}