package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No5549 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            String n = br.readLine();
            int end = Integer.parseInt(String.valueOf(n.charAt(n.length() - 1)));
            if (end % 2 == 0) {
                sb.append("Even\n");
            } else {
                sb.append("Odd\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}