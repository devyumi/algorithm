package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            boolean duplication = false;
            String string = br.readLine();
            int length = string.length() / 3;

            Card[] cards = new Card[4];
            for (int i = 0; i < 4; i++) {
                boolean[] numbers = new boolean[14];
                cards[i] = new Card(numbers);
            }

            Loop:
            for (int i = 0; i < length; i++) {
                char shape = string.charAt(0);
                int index;
                if (string.charAt(1) == '0') {
                    index = Integer.parseInt(String.valueOf(string.charAt(2)));
                } else {
                    index = Integer.parseInt(String.valueOf(string.charAt(2))) + 10;
                }
                switch (shape) {
                    case 'S':
                        if (cards[0].number[index]) {
                            duplication = true;
                            break Loop;
                        }
                        cards[0].number[index] = true;
                        break;

                    case 'D':
                        if (cards[1].number[index]) {
                            duplication = true;
                            break Loop;
                        }
                        cards[1].number[index] = true;
                        break;

                    case 'H':
                        if (cards[2].number[index]) {
                            duplication = true;
                            break Loop;
                        }
                        cards[2].number[index] = true;
                        break;

                    case 'C':
                        if (cards[3].number[index]) {
                            duplication = true;
                            break Loop;
                        }
                        cards[3].number[index] = true;
                        break;
                }
                string = string.substring(3, string.length());
            }

            if (duplication) {
                sb.append("ERROR\n");
            } else {
                for (int i = 0; i < 4; i++) {
                    int count = 0;
                    for (int j = 1; j < 14; j++) {
                        if (!cards[i].number[j]) {
                            count++;
                        }
                    }
                    sb.append(count + " ");
                }
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static class Card {
        private boolean[] number;

        public Card(boolean[] number) {
            this.number = number;
        }
    }
}