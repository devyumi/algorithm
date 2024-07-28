package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) {
                continue;
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            if (map.get(o1) - map.get(o2) != 0) {
                return map.get(o2) - map.get(o1);
            }

            if (o1.length() - o2.length() != 0) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });

        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}