package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a > b && a > c) {
            System.out.print("true ");
        } else {
            System.out.print("false ");
        }

        if (a == b && b == c) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
        br.close();
    }
}
