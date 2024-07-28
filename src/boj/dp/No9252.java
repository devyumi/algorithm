package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No9252 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();
    int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

    for (int i = 1; i < str1.length() + 1; i++) {
      for (int j = 1; j < str2.length() + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        } else {
          lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
        }
      }
    }
    int length = lcs[str1.length()][str2.length()];
    System.out.println(length);


    if (length != 0) {
      ArrayList<Character> results = new ArrayList<>();
      int i = str1.length();
      int j = str2.length();

      while (lcs[i][j] != 0) {
        if (lcs[i][j] == lcs[i - 1][j]) {
          i--;
        } else if (lcs[i][j] == lcs[i][j - 1]) {
          j--;
        } else {
          results.add(str1.charAt(i - 1));
          i--;
          j--;
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int k = results.size() - 1; k >= 0; k--) {
        sb.append(results.get(k));
      }
      System.out.print(sb);
    }
    br.close();
  }
}