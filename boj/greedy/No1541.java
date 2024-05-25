package boj.greedy;

import java.io.*;
import java.util.ArrayList;

public class No1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("-");
        ArrayList<Integer> list = new ArrayList<>();

        for (String s : str) {
            int tmp = 0;
            String[] plus = s.split("\\+");
            for (String p : plus) {
                tmp += Integer.parseInt(p);
            }
            list.add(tmp);
        }

        int sum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            sum -= list.get(i);
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}