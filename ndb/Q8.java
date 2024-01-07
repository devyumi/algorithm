package ndb;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Q8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("");
        ArrayList<String> result = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) >= 65) {
                result.add(arr[i]);
            } else {
                sum += Integer.parseInt(arr[i]);
            }
        }

        Collections.sort(result);
        if (sum != 0) {
            result.add(String.valueOf(sum));
        }

        for (String s : result) {
            bw.write(s);
        }
        bw.close();
    }
}