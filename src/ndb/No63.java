package ndb;

import java.io.*;
import java.util.*;

//map: key-value 정렬
public class No63 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> student = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            student.put(name, score);
        }

        List<String> keySet = new ArrayList<>(student.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return student.get(o1) - student.get(o2);
            }
        });
        for(String str : keySet){
            bw.write(str + " ");
        }
        bw.close();
    }
}