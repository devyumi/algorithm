package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int answer = 0;

            int start = 0;
            int end = b.length() - 1;

            while (end < a.length()) {
                if (a.charAt(start) == b.charAt(0) && a.charAt(end) == b.charAt(b.length() - 1)) {
                    StringBuilder tmp = new StringBuilder();
                    for (int i = start; i <= end; i++) {
                        tmp.append(a.charAt(i));
                    }
                    if (tmp.toString().equals(b.toString())) {
                        start = end + 1;
                        end = start + b.length() - 1;
                        answer++;
                        continue;
                    }
                }
                answer++;
                start++;
                end++;
            }

            if (start != a.length()) {
                for (int i = start; i < a.length(); i++) {
                    answer++;
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}