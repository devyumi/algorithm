package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 기능개발 {

  public int[] solution(int[] progresses, int[] speeds) {
    int[] answer = {};
    List<Integer> cntList = new ArrayList<>();
    boolean[] isDeploy = new boolean[progresses.length + 1];
    Queue<Progress> queue = new LinkedList<>();
    PriorityQueue<Progress> pQ = new PriorityQueue<>((o1, o2) -> o1.order - o2.order);

    for (int i = 0; i < progresses.length; i++) {
      queue.offer(new Progress(i + 1, progresses[i], speeds[i]));
    }

    isDeploy[0] = true;
    while (!queue.isEmpty()) {
      int length = queue.size();
      for (int i = 0; i < length; i++) {
        Progress now = queue.poll();
        if (now.progression >= 100) {
          pQ.offer(now);
        } else {
          queue.offer(new Progress(now.order, now.progression + now.speed, now.speed));
        }
      }

      int cnt = 0;
      while (!pQ.isEmpty()) {
        Progress now = pQ.peek();
        if (isDeploy[now.order - 1]) {
          Progress next = pQ.poll();
          isDeploy[next.order] = true;
          cnt++;
        } else {
          break;
        }
      }

      if (cnt != 0) {
        cntList.add(cnt);
      }
    }
    if (!pQ.isEmpty()) {
      cntList.add(pQ.size());
    }

    answer = new int[cntList.size()];
    for (int i = 0; i < cntList.size(); i++) {
      answer[i] = cntList.get(i);
    }
    return answer;
  }

  private static class Progress {

    private int order;
    private int progression;
    private int speed;

    public Progress(int order, int progression, int speed) {
      this.order = order;
      this.progression = progression;
      this.speed = speed;
    }
  }
}
