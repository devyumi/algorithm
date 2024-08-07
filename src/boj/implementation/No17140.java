package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

//미완성
public class No17140 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[3][3];

        //행, 열 개수 초기화 3
        int row = 3;
        int col = 3;
        int time = 0;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (time > 100) {
                time = -1;
                break;
            }

            if (arr[r][c] == k) {
                break;
            }
            time++;

            //r >= c: 행 연산 / r < c: 열 연산
            if (row >= col) {

                //연산 개수, 결과를 저장하는 배열 (크기 100)
                int[] result = new int[100];
                int index = 0;
                int maxSize = -1;

                for (int i = 0; i < row; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < col; j++) {
                        //숫자, 등장 횟수 저장
                        map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                    }

                    List<Entry<Integer, Integer>> mapList = new LinkedList<>(map.entrySet());
                    //value, key 순 오름차순 정렬
                    Collections.sort(mapList, new Comparator<Entry<Integer, Integer>>() {
                        @Override
                        public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                            if (o1.getValue() == o2.getValue()) {
                                return o1.getKey() - o2.getKey();
                            }
                            return o1.getValue() - o2.getValue();
                        }
                    });

                    maxSize = Math.max(maxSize, mapList.size());
                    result[index++] = mapList.size();

                    for (Entry<Integer, Integer> cal : mapList) {
                        result[index++] = cal.getKey();
                        result[index++] = cal.getValue();
                    }
                }

                //계산 끝. 배열 갱신
                if (maxSize > 100) {
                    maxSize = 100;
                }

                col += maxSize;
                arr = new int[row][col]; //열만 갱신

                int resultIndex = 0;

                Loop:
                for (int i = 0; i < row; i++) {
                    if (result[resultIndex] == 0) {
                        break Loop;
                    }
                    int colIndex = result[resultIndex++];
                    for (int j = 0; j < colIndex * 2; j++) {
                        if (result[resultIndex] == 0) {
                            break Loop;
                        }
                        arr[i][j] = result[resultIndex++];
                    }
                }

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();

            } else {

                //연산 개수, 결과를 저장하는 배열 (크기 100)
                int[] result = new int[100];
                int index = 0;
                int maxSize = -1;

                for (int j = 0; j < col; j++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int i = 0; i < row; i++) {
                        //숫자, 등장 횟수 저장
                        map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                    }

                    List<Entry<Integer, Integer>> mapList = new LinkedList<>(map.entrySet());

                    //value, key 순 오름차순 정렬
                    Collections.sort(mapList, new Comparator<Entry<Integer, Integer>>() {
                        @Override
                        public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                            if (o1.getValue() == o2.getValue()) {
                                return o1.getKey() - o2.getKey();
                            }
                            return o1.getValue() - o2.getValue();
                        }
                    });

                    maxSize = Math.max(maxSize, mapList.size());
                    result[index++] = mapList.size();
                    for (Entry<Integer, Integer> cal : mapList) {
                        result[index++] = cal.getKey();
                        result[index++] = cal.getValue();
                    }
                }

                //계산 끝. 배열 갱신
                if (maxSize > 100) {
                    maxSize = 100;
                }

                row += maxSize;
                arr = new int[row][col]; // 행만 갱신

                int resultIndex = 0;

                Loop:
                for (int j = 0; j < col; j++) {
                    if (result[resultIndex] == 0) {
                        break Loop;
                    }

                    int rowIndex = result[resultIndex++];
                    for (int i = 0; i < rowIndex * 2; i++) {
                        if (result[resultIndex] == 0) {
                            break Loop;
                        }
                        arr[i][j] = result[resultIndex++];
                    }
                }
            }
        }
        System.out.print(time);
        br.close();
    }
}