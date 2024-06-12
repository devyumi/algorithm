package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            int tmp = map.getOrDefault(s, 0);
            if (tmp == 0) {
                map.put(s, 1);
            } else {
                map.replace(s, tmp + 1);
            }
        }

        for (String s : completion) {
            map.replace(s, map.get(s) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
