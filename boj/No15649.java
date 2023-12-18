package boj;

import java.io.*;
import java.util.StringTokenizer;

//백트래킹, 순열
public class No15649 {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new int[m];

        permutation(0);
        bw.close();
    }

    private static void permutation(int depth) throws IOException {
        if (depth == m) {
            for (int i : arr) {
                bw.write(String.valueOf(i) + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
        return;
    }
}