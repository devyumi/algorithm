package programmers.lv2;

import java.util.*;

public class 뒤에_있는_큰_수_찾기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int n = numbers.length;
            int[] answer = new int[n];
            Stack<Integer> stack = new Stack<>();
            stack.add(0);

            for (int i = 1; i < n; i++) {
                while (!stack.isEmpty()) {
                    int beforeIndex = stack.peek();

                    if (numbers[beforeIndex] < numbers[i]) {
                        answer[beforeIndex] = numbers[i];
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.add(i);
            }

            while (!stack.isEmpty()) {
                int index = stack.pop();
                answer[index] = -1;
            }

            return answer;
        }
    }
}
