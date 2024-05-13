package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Lotto[] lottoNumber = new Lotto[n];
            Lotto[] buyingLotto = new Lotto[m];
            int[] money = new int[n];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                char[] numbers = st.nextToken().toCharArray();
                money[i] = Integer.parseInt(st.nextToken());
                lottoNumber[i] = new Lotto(numbers);
            }

            for (int i = 0; i < m; i++) {
                char[] numbers = br.readLine().toCharArray();
                buyingLotto[i] = new Lotto(numbers);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (isLotto(lottoNumber[i].numbers, buyingLotto[j].numbers)) {
                        sum += money[i];
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static boolean isLotto(char[] c1, char[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != '*') {
                for (int j = i; j < c2.length; j++) {
                    if (c1[i] != c2[j]) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
    }

    private static class Lotto {
        private char[] numbers;

        public Lotto(char[] numbers) {
            this.numbers = numbers;
        }
    }
}