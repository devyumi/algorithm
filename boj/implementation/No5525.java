package boj.implementation;

import java.io.*;

public class No5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        char[] pnArr = new char[2 * n + 2];
        StringBuilder pn = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int result = 0;

        for (int i = 0; i < pnArr.length; i++) {
            if (i % 2 == 0) {
                pnArr[i] = 'O';
            } else {
                pnArr[i] = 'I';
            }
        }

        for (int i = 1; i < pnArr.length; i++) {
            pn.append(pnArr[i]);
        }

        for (int i = 0; i < m; i++) {
            if (chars[i] == 'O') {
                continue;
            }

            if (i + pnArr.length - 1 <= m) {
                for (int j = i; j < m; j++) {
                    tmp.append(chars[j]);
                    if (tmp.length() == pnArr.length - 1) {
                        if (tmp.toString().equals(pn.toString())) {
                            result++;
                        }
                        tmp.setLength(0);
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}