package programmers.lv2;

import java.util.*;

public class H_Index {
    class Solution {
        public int solution(int[] citations) {
            Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
            Arrays.sort(arr, Collections.reverseOrder());

            int n = citations.length;
            int answer = 0; //h-index

            for (int i = 0; i < n; i++) {
                if (arr[i] >= i + 1) {
                    answer = i + 1;
                } else {
                    break;
                }
            }
            return answer;
        }
    }
}
