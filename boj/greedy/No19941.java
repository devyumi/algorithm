package boj.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class No19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                boolean tmp = false;
                for (int j = k; j > 0; j--) {
                    if (i - j >= 0 && arr[i - j] == 'H' && !visited[i - j]) {
                        tmp = true;
                        visited[i - j] = true;
                        answer++;
                        break;
                    }
                }

                if (!tmp) {
                    for (int j = 1; j <= k; j++) {
                        if (i + j < n && arr[i + j] == 'H' && !visited[i + j]) {
                            if (!visited[i + j]) {
                                visited[i + j] = true;
                                answer++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}