package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2441 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    int blank = 0;

    for (int i = n; i > 0; i--) {
      for (int j = 0; j < blank; j++) {
        sb.append(" ");
      }
      for (int j = 0; j < i; j++) {
        sb.append("*");
      }
      blank++;
      sb.append("\n");
    }
    System.out.print(sb.deleteCharAt(sb.length() - 1));
    br.close();
  }
}
