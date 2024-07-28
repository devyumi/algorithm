package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> calMap = new HashMap<>();
    int sum = 0;
    int cnt;

    for (int i = 0; i < want.length; i++) {
      map.put(want[i], number[i]);
      sum += number[i];
    }

    for (int i = 0; i < discount.length; i++) {
      if (i + sum <= discount.length) {
        cnt = sum;
        calMap.putAll(map);
        for (int j = i; j < i + sum; j++) {
          if (calMap.containsKey(discount[j])) {
            int tmp = calMap.get(discount[j]);
            if (tmp != 0) {
              tmp--;
              calMap.put(discount[j], tmp);
              cnt--;
            } else {
              break;
            }
          } else {
            break;
          }
        }
        if (cnt == 0) {
          answer++;
        }
      } else {
        break;
      }
    }
    return answer;
  }
}