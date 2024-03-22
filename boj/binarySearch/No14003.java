package boj.binarySearch;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class No14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        int[] result = new int[n];
        int length = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[length++] = arr[0];
        result[0] = length;
        for (int i = 1; i < n; i++) {
            if (lis[length - 1] < arr[i]) {
                lis[length++] = arr[i];
                result[i] = length;
            } else {
                int index = binarySearch(lis, arr[i], length);
                lis[index] = arr[i];
                result[i] = index + 1;
            }
        }

        bw.write(length + "\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] == length) {
                stack.push(arr[i]);
                length--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.close();
    }

    private static int binarySearch(int[] arr, int key, int end) {
        int start = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}