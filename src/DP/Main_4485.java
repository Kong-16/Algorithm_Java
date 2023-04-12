package DP;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main_4485 {
    public static int t;
    public static int n;
    public static int max = 1000000;
    public static int[][] board;
    public static int[][] dp;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static class Pos {
        public int r;
        public int c;


        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    // BFS로 모든 경로 방문.
    public static void bfs() {
        ArrayDeque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0, 0));
        while (!deque.isEmpty()) {
            Pos curPos = deque.poll();
            int curR = curPos.r;
            int curC = curPos.c;
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                if (inRange(nextR, nextC)) {
                    // 같은 경로에 대해 비용이 더 크거나 같은 경로의 경우, 저장하지 않음.
                    // 등호 넣으면 시간초과 / 메모리 초과.
                    if (board[nextR][nextC] + dp[curR][curC] < dp[nextR][nextC]) {
                        Pos tmp = new Pos(nextR, nextC);
                        deque.add(tmp);
                        dp[nextR][nextC] = board[nextR][nextC] + dp[curR][curC];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int test_case = 1; ; test_case++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            board = new int[n][n];
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = max;
                }
            }
            dp[0][0] = board[0][0];
            bfs();
            bw.write("Problem " + test_case + ": " + dp[n - 1][n - 1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}