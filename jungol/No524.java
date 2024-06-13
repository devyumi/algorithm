package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean c = true;
        boolean d = true;

        if (a == 0) {
            c = false;
        }
        if (b == 0) {
            d = false;
        }

        System.out.print((c && d) + " " + (c || d));
        br.close();
    }
}
