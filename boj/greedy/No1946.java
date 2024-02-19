package boj.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Test> test = new ArrayList<>();
            int result = 1;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                test.add(new Test(first, second));
            }

            Collections.sort(test, (o1, o2) -> o1.first - o2.first);
            int min = test.get(0).second;
            for (int i = 1; i < n; i++) {
                if (test.get(i).second < min) {
                    result++;
                    min = test.get(i).second;
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
    }

    private static class Test {
        private int first;
        private int second;

        public Test(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}