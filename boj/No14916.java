package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int change = n;
        int count = 0;

        if (n / 5 > 0) {
            count += n / 5;
            n %= 5;
        }

        if (n % 2 != 0) {
            n = count * 5 + n;
            count--;
            n -= 5 * count;
        }
        
        count += n / 2;
        if (change == 1 || change == 3) {
            count = -1;
        }
        System.out.print(count);
    }
}