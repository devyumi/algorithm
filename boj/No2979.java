package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2979 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int parkingFee = 0;
        int[] truck = new int[101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());

            for (int j = start; j < finish; j++) {
                truck[j]++;
            }
        }

        for (int i = 0; i < truck.length; i++) {
            if (truck[i] == 1) {
                parkingFee += a;
            } else if (truck[i] == 2) {
                parkingFee += b * 2;
            } else if (truck[i] == 3) {
                parkingFee += c * 3;
            }
        }
        System.out.print(parkingFee);
    }
}