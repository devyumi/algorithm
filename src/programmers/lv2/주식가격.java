package programmers.lv2;

import java.util.*;

public class 주식가격 {
    class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n];
            Stack<Integer> stack = new Stack<>();
            stack.add(0);

            for (int i = 1; i < n; i++) {
                while (!stack.isEmpty()) {
                    int beforeIndex = stack.peek();

                    if (prices[beforeIndex] > prices[i]) {
                        answer[beforeIndex] = i - beforeIndex;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.add(i);
            }

            int lastIndex = stack.pop();
            while (!stack.isEmpty()) {
                int index = stack.pop();
                answer[index] = lastIndex - index;
            }
            answer[lastIndex] = 0;

            return answer;
        }
    }
}
