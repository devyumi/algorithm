package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No7087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            int index = 65;
            int count = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);
            for (String s : arr) {
                if ((int) s.charAt(0) == index) {
                    count++;
                    index++;
                } else if ((int) s.charAt(0) == index - 1) {
                    continue;
                } else {
                    break;
                }
            }
            sb.append(count + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}