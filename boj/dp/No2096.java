package boj.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dpMin = new int[n][3];
        int[][] dpMax = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dpMin[0][i] = arr[0][i];
            dpMax[0][i] = arr[0][i];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dpMin[i][j] = Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]) + arr[i][j];
                    dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]) + arr[i][j];
                } else if (j == 2) {
                    dpMin[i][j] = Math.min(dpMin[i - 1][j - 1], dpMin[i - 1][j]) + arr[i][j];
                    dpMax[i][j] = Math.max(dpMax[i - 1][j - 1], dpMax[i - 1][j]) + arr[i][j];
                } else {
                    dpMin[i][j] = Math.min(Math.min(dpMin[i - 1][j - 1], dpMin[i - 1][j]), dpMin[i - 1][j + 1]) + arr[i][j];
                    dpMax[i][j] = Math.max(Math.max(dpMax[i - 1][j - 1], dpMax[i - 1][j]), dpMax[i - 1][j + 1]) + arr[i][j];
                }
            }
        }

        int max = Arrays.stream(dpMax[n - 1]).max().getAsInt();
        int min = Arrays.stream(dpMin[n - 1]).min().getAsInt();

        bw.write(max + " " + min);
        bw.close();
    }
}