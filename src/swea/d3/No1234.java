package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();
            ArrayList<Character> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(arr[i]);
            }

            int start = 0;
            int end = start + 1;
            while (end < list.size()) {
                if (list.get(start) == list.get(end)) {
                    list.remove(start);
                    list.remove(start);
                    if (start != 0) {
                        start--;
                        end--;
                    } else {
                        start = 0;
                        end = start + 1;
                    }
                    continue;
                }
                start++;
                end++;
            }
            sb.append("#").append(t).append(" ");
            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}