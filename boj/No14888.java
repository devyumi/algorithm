package boj;

import java.io.*;
import java.util.StringTokenizer;

public class No14888 {
    private static int n;
    private static int[] number;
    private static int[] operator;
    private static int max = (int) -1e9;
    private static int min = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        number = new int[n];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(number[0], 1);

        bw.write(max + "\n");
        bw.write(String.valueOf(min));
        bw.close();
    }

    private static void dfs(int num, int index) {
        if (index == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(num + number[index], index + 1);
                        break;
                    case 1:
                        dfs(num - number[index], index + 1);
                        break;
                    case 2:
                        dfs(num * number[index], index + 1);
                        break;
                    case 3:
                        dfs(num / number[index], index + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}