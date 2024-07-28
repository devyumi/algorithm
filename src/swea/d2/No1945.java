package swea.d2;

import java.io.*;

public class No1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 1; k <= t; k++) {
            sb.append("#").append(k).append(" ");

            int n = Integer.parseInt(br.readLine());
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;

            while (n != 1) {
                if (n % 11 == 0) {
                    e++;
                    n /= 11;
                } else if (n % 7 == 0) {
                    d++;
                    n /= 7;
                } else if (n % 5 == 0) {
                    c++;
                    n /= 5;
                } else if (n % 3 == 0) {
                    b++;
                    n /= 3;
                } else if (n % 2 == 0) {
                    a++;
                    n /= 2;
                } else {
                    break;
                }
            }

            sb.append(a + " " + b + " " + c + " " + d + " " + e);
            if (k != t) {
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
