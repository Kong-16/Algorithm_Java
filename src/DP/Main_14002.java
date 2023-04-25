package DP;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_14002 {
    public static int n, cnt, lastIdx;
    public static int[] input;
    public static int[][] dp;
    public static int[] prev;

    public static int binarySearch(int find) {
        int idx = 0;
        int start = 0;
        int end = lastIdx;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (find <= dp[mid][0]) {
                end = mid - 1;
            } else {
                idx = mid;
                start = mid + 1;
            }
        }
        return idx;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        input = new int[n + 1];
        dp = new int[n + 1][2];
        prev = new int[n + 1];
        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = -1;
        lastIdx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            int idx = binarySearch(input[i]);
            dp[idx + 1][0] = input[i];
            //dp[i]가 input의 어떤 수 에서 왔는지
            dp[idx + 1][1] = i;
            if (idx == lastIdx) lastIdx++;
            // 어떤 input값을 골라서 왔는지를 prev에 저장. (부분수열의 이전 숫자)
            prev[i] = dp[idx][1];
        }
        bw.write(lastIdx + "\n");
        // 역추적. idx가 -1이 될 때 까지 prev로 추적함.
        Stack<Integer> stack = new Stack<>();
        int idx = dp[lastIdx][1];
        while (0 < idx) {
            stack.push(input[idx]);
            idx = prev[idx];
        }

        while (!stack.empty()) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
        bw.close();
    }
}