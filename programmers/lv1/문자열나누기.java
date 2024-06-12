package programmers.lv1;

public class 문자열나누기 {
    public int solution(String s) {
        int answer = 0;

        Loop:
        while (true) {
            int x = s.charAt(0);
            int cnt1 = 0;
            int cnt2 = 0;

            for (int i = 0; i < s.length(); i++) {
                if (x == s.charAt(i)) {
                    cnt1++;
                } else {
                    cnt2++;
                }

                if (cnt1 == cnt2) {
                    answer++;

                    if (cnt1 + cnt2 == s.length()) {
                        break Loop;
                    } else {
                        s = s.substring(cnt1 + cnt2, s.length());
                        break;
                    }
                }

                if (i == s.length() - 1) {
                    answer++;
                    break Loop;
                }
            }
        }
        return answer;
    }
}
