package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class No7701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                set.add(br.readLine());
            }

            ArrayList<String> list = new ArrayList(set);
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o1.length() - o2.length();
                }
            });

            sb.append("#").append(t).append("\n");
            for (String s : list) {
                sb.append(s).append("\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}