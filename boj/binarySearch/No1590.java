package boj.binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                list.add(s + l * j);
            }
        }

        Collections.sort(list);
        bw.write(String.valueOf(binarySearch(list, t)));
        bw.close();
    }

    private static int binarySearch(ArrayList<Integer> list, int key) {
        int start = 0;
        int end = list.size() - 1;
        int min = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
                min = Math.min(min, list.get(mid));
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min - key;
        }
    }
}