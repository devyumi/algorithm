package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#" + br.readLine() + " ");
            String finding = br.readLine();
            String searching = br.readLine();
            sb.append(searchString(finding, searching) + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int searchString(String finding, String searching) {
        int answer = 0;
        String subString = searching;

        while (true) {
            int index = subString.indexOf(finding);

            if (!subString.contains(finding)) {
                return answer;
            } else {
                answer++;
                subString = subString.substring(index + 1);
            }
        }
    }
}