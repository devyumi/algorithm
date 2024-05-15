package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());

            int speed = 0;
            int distance = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());

                if (command == 1) {
                    speed += Integer.parseInt(st.nextToken());
                } else if (command == 2) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (speed - tmp < 0) {
                        speed = 0;
                    } else {
                        speed -= tmp;
                    }
                }
                distance += speed;
            }
            sb.append("#").append(t).append(" ").append(distance).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}
