package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append("\n");
            int n = Integer.parseInt(br.readLine());
            ArrayList<Document> list = new ArrayList<>();
            int length = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Document(st.nextToken().charAt(0), Integer.parseInt(st.nextToken())));
            }

            int i = 0;
            while (true) {
                if (list.get(list.size() - 1).count == 0) {
                    break;
                }

                if (length == 10) {
                    length = 0;
                    sb.append("\n");
                    continue;
                }

                if (list.get(i).count != 0) {
                    sb.append(list.get(i).alphabet);
                    list.get(i).count--;
                    length++;
                } else {
                    i++;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static class Document {
        private char alphabet;
        private int count;

        public Document(char alphabet, int count) {
            this.alphabet = alphabet;
            this.count = count;
        }
    }
}