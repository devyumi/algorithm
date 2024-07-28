package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + br.readLine() + " ");
            int[][] arr = new int[100][100];
            int answer = 0;
            int sum = 0;

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    sum += arr[i][j];
                }
                answer = Math.max(answer, sum);
                sum = 0;
            }

            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < 100; i++) {
                    sum += arr[i][j];
                }
                answer = Math.max(answer, sum);
                sum = 0;
            }

            int i = 0;
            int j = 99;
            while (j >= 0) {
                sum += arr[i++][j--];
            }
            answer = Math.max(answer, sum);
            sum = 0;

            i = 0;
            j = 0;
            while (j < 100) {
                sum += arr[i++][j++];
            }
            answer = Math.max(answer, sum);
            sum = 0;

            sb.append(answer + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}