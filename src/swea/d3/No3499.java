package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int k = 1; k <= t; k++) {
            sb.append("#" + k + " ");
            int n = Integer.parseInt(br.readLine());
            String[] card = br.readLine().split(" ");
            int cardIndex;

            if (n % 2 == 0) {
                cardIndex = n / 2;
            } else {
                cardIndex = n / 2 + 1;
            }

            for (int i = 0; i < cardIndex; i++) {
                sb.append(card[i] + " ");
                if (i + cardIndex < card.length) {
                    sb.append(card[i + cardIndex] + " ");
                }
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}