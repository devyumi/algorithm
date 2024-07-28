package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No10814 {

    // 2차원 ArrayList, counting sort

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<String>[] member = new ArrayList[201];
        for(int i = 1; i < 201; i++){
            member[i] = new ArrayList<>();
        }

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            member[age].add(name);
        }

        for(int i = 1; i < 201; i++){
            for(int j = 0; j < member[i].size(); j++){
                System.out.println(i + " " + member[i].get(j));
            }
        }
    }
}
