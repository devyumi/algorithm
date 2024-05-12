package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();
            int indexA = a.length - 1;
            int indexB = b.length - 1;
            int[] intA = new int[a.length];
            int[] intB = new int[b.length];

            for (int i = 0; i < a.length; i++) {
                intA[i] = Integer.parseInt(String.valueOf(a[indexA--]));
            }

            for (int i = 0; i < b.length; i++) {
                intB[i] = Integer.parseInt(String.valueOf(b[indexB--]));
            }
            sb.append(sum(intA, intB) + "\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static String sum(int[] a, int[] b) {
        StringBuilder answer = new StringBuilder();

        if (a.length > b.length) {
            for (int i = 0; i < b.length; i++) {
                int sum = b[i] + a[i];
                if (sum >= 10) {
                    sum -= 10;
                    a[i + 1] += 1;
                }
                answer.append(sum);
            }

            for (int i = b.length; i < a.length; i++) {
                if (a[i] >= 10 && i != a.length - 1) {
                    a[i] -= 10;
                    a[i + 1] += 1;
                }
                if (a[i] >= 10 && i == a.length - 1) {
                    a[i] -= 10;
                    answer.append(a[i]).append(1);
                } else {
                    answer.append(a[i]);
                }
            }
        } else if (a.length == b.length) {
            for (int i = 0; i < b.length; i++) {
                int sum = b[i] + a[i];
                if (sum >= 10 && i != b.length - 1) {
                    sum -= 10;
                    a[i + 1] += 1;
                }
                if (sum >= 10) {
                    sum -= 10;
                    answer.append(sum).append(1);
                } else {
                    answer.append(sum);
                }
            }
        } else {
            for (int i = 0; i < a.length; i++) {
                int sum = b[i] + a[i];
                if (sum >= 10) {
                    sum -= 10;
                    b[i + 1] += 1;
                }
                answer.append(sum);
            }

            for (int i = a.length; i < b.length; i++) {
                if (b[i] >= 10 && i != b.length - 1) {
                    b[i] -= 10;
                    b[i + 1] += 1;
                }
                if (b[i] >= 10 && i == b.length - 1) {
                    b[i] -= 10;
                    answer.append(b[i]).append(1);
                } else {
                    answer.append(b[i]);
                }
            }
        }
        return answer.reverse().toString();
    }
}