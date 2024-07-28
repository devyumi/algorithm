package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[8][8];
            char[][] col = new char[8][8];
            int answer = 0;

            for (int i = 0; i < 8; i++) {
                char[] string = br.readLine().toCharArray();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = string[j];
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    col[j][i] = arr[i][j];
                }
            }

            int k = n - 1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - n; j++) {
                    answer += palindrome(arr[i], j, k++);
                }
                k = n - 1;
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - n; j++) {
                    answer += palindrome(col[i], j, k++);
                }
                k = n - 1;
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int palindrome(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return 0;
            }
            start++;
            end--;
        }
        return 1;
    }
}