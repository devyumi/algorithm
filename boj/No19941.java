package boj;

import java.io.*;
import java.util.StringTokenizer;

public class No19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = new char[n];
        boolean[] visited = new boolean[n];
        int result = 0;

        String[] str = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            arr[i] = str[i].charAt(0);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                int tmp = 0;
                for (int j = k; j > 0; j--) {
                    if (i - j >= 0 && arr[i - j] == 'H') {
                        if (!visited[i - j]) {
                            result++;
                            visited[i - j] = true;
                            tmp = 1;
                            break;
                        }
                    }
                }

                if (tmp == 0) {
                    for (int j = 1; j <= k; j++) {
                        if (i + j < n && arr[i + j] == 'H') {
                            if (!visited[i + j]) {
                                result++;
                                visited[i + j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}