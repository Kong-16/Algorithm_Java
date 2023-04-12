package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098 {
    public static int max = 100000000;
    public static int n;
    public static int[][] weight;
    public static int[][] dp;
    public static int full;

    public static int dfs(int cur, int visit) {
        // 재귀 종료 조건. 모든 마을을 방문한 경우.
        if (visit == full) {
            int goal = weight[cur][0];
            if (goal < max) {
                dp[cur][visit] = goal;
                return goal;
            } else {
                // 다 돌았는데 방문 불가능한 경우와 돌지 않은 경우 나누기 위해 max-1저장.
                return max - 1;
            }
        }
        if (dp[cur][visit] < max)
            return dp[cur][visit];

        // 방문했으므로 max-1 저장.
        dp[cur][visit] = max - 1;
        for (int i = 0; i < n; i++) {
            int cmp = (1 << i);
            if ((cmp & visit) == 0 && weight[cur][i] < max) {
                dp[cur][visit] = Math.min(dp[cur][visit], dfs(i, cmp | visit) + weight[cur][i]);
            }
        }
        return dp[cur][visit];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        full = (1 << n) - 1;
        weight = new int[n][n];
        //dp[i][j] = j마을들을 방문한 뒤 i의 위치에서 출발한 마을로 돌아오기 위해 들러야 하는 나머지 마을들의 최소 비용
        dp = new int[n][full + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], max);
            for (int j = 0; j < n; j++) {
                int w = Integer.parseInt(st.nextToken());
                // 갈 수 없는 경우 최댓값 저장
                w = w == 0 ? max : w;
                weight[i][j] = w;
            }
        }
        dfs(0, 1);
        bw.write(dp[0][1] + "\n");
        bw.flush();
        bw.close();
    }
}