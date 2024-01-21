package boj;

import java.io.*;
import java.util.StringTokenizer;

//backTracking
public class No14888 {
    private static int n;
    private static int[] arr;
    private static int[] operator;
    private static int max = -(int) 1e9;
    private static int min = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        operator = new int[4];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(arr[0], 1);
        bw.write(String.valueOf(max));
        bw.write("\n" + min);
        bw.close();
    }

    private static void backTracking(int number, int depth) {
        if (depth == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        backTracking(number + arr[depth], depth + 1);
                        break;
                    case 1:
                        backTracking(number - arr[depth], depth + 1);
                        break;
                    case 2:
                        backTracking(number * arr[depth], depth + 1);
                        break;
                    case 3:
                        backTracking(number / arr[depth], depth + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}