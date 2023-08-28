package ndb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = Integer.parseInt(br.readLine());
        int coin_count = 0;

        while (change != 0) {
            coin_count += change / 500;
            change = change % 500;
            coin_count += change / 100;
            change = change % 100;
            coin_count += change / 50;
            change = change % 50;
            coin_count += change / 10;
            change = change % 10;
        }
        System.out.println("coin_count = " + coin_count);
    }
}