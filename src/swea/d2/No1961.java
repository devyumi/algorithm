package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1961 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            System.out.println("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            String[][] answer = new String[n][3];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int i = 0;
            int j = 0;
            for (int k = 0; k < n; k++) {
                StringBuilder sb = new StringBuilder();
                for (int l = n - 1; l >= 0; l--) {
                    sb.append(arr[l][k]);
                }
                answer[i++][j] = sb.toString();
            }


            i = 0;
            j++;
            for (int k = n - 1; k >= 0; k--) {
                StringBuilder sb = new StringBuilder();
                for (int l = n - 1; l >= 0; l--) {
                    sb.append(arr[k][l]);
                }
                answer[i++][j] = sb.toString();
            }

            i = 0;
            j++;
            for (int k = n - 1; k >= 0; k--) {
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < n; l++) {
                    sb.append(arr[l][k]);
                }
                answer[i++][j] = sb.toString();
            }

            for (int k = 0; k < n; k++) {
                for (int l = 0; l < 3; l++) {
                    System.out.print(answer[k][l]);
                    if (l != 2) {
                        System.out.print(" ");
                    }
                }
                if (k != n - 1) {
                    System.out.println();
                }
            }

            if (t != tc) {
                System.out.println();
            }
        }
        br.close();
    }
}