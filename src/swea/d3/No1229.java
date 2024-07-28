package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#" + tc + " ");

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int operation = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < operation; i++) {
                String command = st.nextToken();
                int index = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    for (int j = 0; j < count; j++) {
                        list.add(index, Integer.parseInt(st.nextToken()));
                        index++;
                    }
                } else {
                    for (int j = 0; j < count; j++) {
                        list.remove(index);
                    }
                }
            }
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i) + " ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}