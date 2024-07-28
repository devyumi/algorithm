package programmers.lv1;

import java.util.*;

public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        int todayY = Integer.parseInt(today.substring(0, 4));
        int todayM = Integer.parseInt(today.substring(5, 7));
        int todayD = Integer.parseInt(today.substring(8, 10));
        int todayDay = makeDay(todayY, todayM, todayD);

        Map<String, Integer> map = new HashMap<>();
        for (String s : terms) {
            StringTokenizer st = new StringTokenizer(s);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String tmp = st.nextToken();
            String term = st.nextToken();
            int privacyY = Integer.parseInt(tmp.substring(0, 4));
            int privacyM = Integer.parseInt(tmp.substring(5, 7));
            int privacyD = Integer.parseInt(tmp.substring(8, 10));
            int privacyDay = makeDay(privacyY, privacyM, privacyD);
            privacyDay += (map.get(term) * 28);

            if (todayDay >= privacyDay) {
                list.add(i + 1);
            }
        }
        answer = new int[list.size()];
        int cnt = 0;
        for (int i : list) {
            answer[cnt++] = i;
        }

        Arrays.sort(answer);
        return answer;
    }

    private static int makeDay(int y, int m, int d) {
        return (y * 12 * 28) + (m * 28) + d;
    }
}
