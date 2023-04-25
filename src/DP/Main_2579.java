package DP;

import java.io.*;
import java.util.Arrays;

public class Main_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] inpArr = new int[n + 1];
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            inpArr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            bw.write(inpArr[1] + "\n");
            bw.flush();
            bw.close();
            System.exit(0);
        }
        dp[2][1] = inpArr[2];
        dp[1][0] = inpArr[1];
        dp[2][0] = inpArr[2] + inpArr[1];

        for (int i = 3; i <= n; i++) {
            dp[i][1] = inpArr[i] + Math.max(dp[i - 2][0], dp[i - 2][1]);
            dp[i][0] = inpArr[i] + dp[i - 1][1];
        }
        bw.write(Math.max(dp[n][0], dp[n][1]) + "\n");
        bw.flush();
        bw.close();
    }
}
