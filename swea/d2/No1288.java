package swea.d2;

import java.io.*;

public class No1288 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int l = 1; l <= t; l++) {
            sb.append("#" + l + " ");
            int n = Integer.parseInt(br.readLine());
            char[] nChar;
            int k = 0;
            int sheep;
            int sum;
            int[] arr = new int[10];

            do {
                k++;
                sheep = n * k;
                nChar = String.valueOf(sheep).toCharArray();
                sum = 0;
                for (char c : nChar) {
                    int index = Integer.parseInt(String.valueOf(c));
                    if (arr[index] == 0) {
                        arr[index]++;
                    }
                }

                for (int i : arr) {
                    sum += i;
                }
            } while (sum != 10);

            sb.append(sheep);

            if (l != t) {
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
