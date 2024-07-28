package ndb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No42 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i <= n; i++) {
            String st1 = i + "";
            for (int j = 0; j < 60; j++) {
                String st2 = j + "";
                for (int k = 0; k < 60; k++) {
                    String st3 = k + "";
                    String st4 = st1 + st2 + st3;
                    if (st4.contains("3")) {
                        result++;
                    }
                }
            }
        }
        System.out.print(result);
    }
}
