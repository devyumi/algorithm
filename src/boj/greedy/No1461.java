package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //양수, 음수 각각 계산
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int plusCount = 0;
        int minusCount = 0;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp > 0) {
                plusCount++;
                plus.add(tmp);
                continue;
            }
            minusCount++;
            minus.add(tmp);
        }

        Collections.sort(plus);
        minus.sort(Collections.reverseOrder());
    }
}
