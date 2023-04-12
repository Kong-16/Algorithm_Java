package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15486 {
    public static int n;
    public static int[] dp;
    public static int[][] consulting;
    public static int penalty = -2000000000;


    // cur일 기준 벌 수 있는 돈의 최댓값 구하기.
    public static int dfs(int cur) {
        if (n < cur)
            return penalty;
        if (n == cur)
            return 0;
        //방문한 곳이면 다시 계산하지 않음.
        if (dp[cur] != -1) return dp[cur];
        // 오늘 상담하고 상담 끝난 일 기준 최댓 값 더하기 vs 상담 안하기
        dp[cur] = Math.max(dfs(cur + consulting[cur][0]) + consulting[cur][1], dfs(cur + 1));
        return dp[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        // 방문 체크를 위해 -1로 초기화. max 최솟값이 0이므로 방문 체크 가능.
        Arrays.fill(dp, -1);
        consulting = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            consulting[i][0] = Integer.parseInt(st.nextToken());
            consulting[i][1] = Integer.parseInt(st.nextToken());
        }
        // dp를 마지막 부터 채워나가기 때문에 dfs를 마지막 부터 채워 나감.
        for (int i = n; 0 <= i; i--) {
            dfs(i);
        }
        bw.write(dp[0] + "\n");
        bw.flush();
        bw.close();

    }
}
