package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5215 {
    public static int n;
    public static int l;
    public static int[][] dp;
    public static int[] score;
    public static int[] cal;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            dp = new int[n + 1][l + 1];
            score = new int[n + 1];
            cal = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(bf.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {// 재료 0번 ~ n-1번 까지 넣어보기
                for (int j = 1; j <= l; j++) { // 칼로리 1 ~ 1000까지 채워보기
                    if (j < cal[i]) {// j보다 무게가 큰 경우, 재료 i 못넣음. => 이전의 재료까지 넣는 것이 최적.
                        dp[i][j] = dp[i - 1][j];
                    } else {// i를 넣을 수 있는 경우엔, 이전까지 재료만 넣기(i 안넣기) vs i 넣고 j - cal[i]무게 만큼 재료 넣기
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cal[i]] + score[i]);
                    }
                }
            }
            bw.write("#" + test_case + " " + dp[n][l] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
