package ndb;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//counting sort
//문제에는 제시되어 있지 않지만, 이름과 성적이 같은 경우가 있을 수 있으므로 해당 방법이 적절해보임
public class No63_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<String>[] student = new ArrayList[101];
        for (int i = 0; i < student.length; i++) {
            student[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            student[score].add(name);
        }

        for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < student[i].size(); j++) {
                bw.write(student[i].get(j) + " ");
            }
        }
    }
}
