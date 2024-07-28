package boj.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1744 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int answer = 0;
    PriorityQueue<Integer> positivePQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> negativePQ = new PriorityQueue<>(Comparator.comparingInt(o -> o));

    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(br.readLine());
      if (tmp > 0) {
        positivePQ.offer(tmp);
      } else {
        negativePQ.offer(tmp);
      }
    }
    answer += sum(positivePQ);
    answer += sum(negativePQ);
    bw.write(String.valueOf(answer));
    bw.close();
    br.close();
  }

  private static int sum(PriorityQueue<Integer> pQ) {
    int sum = 0;
    while (!pQ.isEmpty()) {
      if (pQ.size() == 1) {
        sum += pQ.poll();
        break;
      }
      int a = pQ.poll();
      int b = pQ.poll();

      if (isMulti(a, b)) {
        sum += a * b;
      } else {
        sum += a + b;
      }
    }
    return sum;
  }

  private static boolean isMulti(int a, int b) {
    if (a > 1 && b > 1) {
      return true;
    } else if (a < 0 && b < 0) {
      return true;
    } else if (a == 0 && b < 0) {
      return true;
    } else if (a < 0 && b == 0) {
      return true;
    }
    return false;
  }
}