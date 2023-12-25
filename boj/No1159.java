package boj;

import java.io.*;

//구현
public class No1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int[] result = new int[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            int alphabetIndex = arr[i].charAt(0);
            result[alphabetIndex - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (result[i] >= 5) {
                char alphabet = (char) (i + 97);
                sb.append(alphabet);
            }
        }

        if (sb.length() == 0) {
            bw.write("PREDAJA");
        } else {
            bw.write(sb.toString());
        }
        bw.close();
    }
}