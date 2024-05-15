package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1974 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(t).append(" ").append(checkArr(arr)).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    private static int checkArr(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (!visited[arr[j][i]]) {
                    visited[arr[j][i]] = true;
                } else {
                    return 0;
                }
            }
        }

        boolean[] visited = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        visited = new boolean[10];
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        visited = new boolean[10];
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        visited = new boolean[10];
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        visited = new boolean[10];
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        visited = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        visited = new boolean[10];
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        visited = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }

        visited = new boolean[10];
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if (!visited[arr[i][j]]) {
                    visited[arr[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }
}