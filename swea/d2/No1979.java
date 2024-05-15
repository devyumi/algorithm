package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            int count = 0;
            int answer = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        count++;
                    } else if (arr[i][j] == 0) {
                        if (count == k) {
                            answer++;
                        }
                        count = 0;
                    }
                }
                if (count == k) {
                    answer++;
                }
                count = 0;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j][i] == 1) {
                        count++;
                    } else if (arr[j][i] == 0) {
                        if (count == k) {
                            answer++;
                        }
                        count = 0;
                    }
                }
                if (count == k) {
                    answer++;
                }
                count = 0;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}