package boj.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class No2668 {
    private static int n;
    private static int[] arr;
    private static boolean[] visited;
    private static ArrayList<Integer> integers = new ArrayList<>();
    private static int last;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n + 1; i++) {
            last = i;
            dfs(i);
        }

        Collections.sort(integers);
        bw.write(integers.size() + "\n");
        for (int i : integers) {
            bw.write(i + "\n");
        }
        bw.close();
    }

    private static void dfs(int x) {
        if (!visited[x]) {
            visited[x] = true;

            if (last == arr[x]) {
                integers.add(last);
            }

            dfs(arr[x]);
            visited[x] = false;
        }
    }
}