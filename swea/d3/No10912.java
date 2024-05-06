package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No10912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int[] alphabet = new int[26];
            char[] string = br.readLine().toCharArray();
            ArrayList<Character> list = new ArrayList<>();

            for (int i = 0; i < string.length; i++) {
                alphabet[(int) string[i] - 97]++;
            }

            for (int i = 0; i < 26; i++) {
                if (alphabet[i] % 2 == 1) {
                    list.add((char) (i + 97));
                }
            }

            if (list.size() == 0) {
                sb.append("Good\n");
            } else {
                Collections.sort(list);
                for (char c : list) {
                    sb.append(c);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}