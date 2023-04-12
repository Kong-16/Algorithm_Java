package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1699 {
    public static int n;
    public static int max = 1000000000;
    public static ArrayList<Integer> square = new ArrayList<>();
    public static int[] dp;

    public static int getBiggestSquare(int number) {
        int root = (int) Math.sqrt(number);
        return root * root;
    }

    public static int dfs(int cur) {
        if (dp[cur] != max) return dp[cur];
        // 가능한 제곱 수들의 합 중 최솟값.
        for (int s : square) {
            if (cur < s) break;
            dp[cur] = Math.min(dp[cur], dp[cur - s] + 1);
        }
        return dp[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, max);
        // 제곱수 1로 초기화.
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
            square.add(i * i);
        }
        for (int i = 1; i <= n; i++) {
            dfs(i);
        }
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();

    }
}
