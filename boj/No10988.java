package boj;

import java.io.*;

//구현, 문자 뒤집기
public class No10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        String reverse = new StringBuilder(word).reverse().toString();

        if (word.equals(reverse)) {
            bw.write(String.valueOf(1));
        } else {
            bw.write(String.valueOf(0));
        }
        bw.close();
    }
}