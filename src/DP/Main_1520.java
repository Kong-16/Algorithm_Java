package DP;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1520 {
    public static int m;
    public static int n;
    public static int h;
    public static int[][] map;
    public static int[][] dp;
    public static boolean[][] visited;

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }

    public static int dfs(int r, int c) {
        if (r == m - 1 && c == n - 1) {
            //목적지 도달 시, 가능한 경로 +1
            return 1;
        }
        // 이미 방문한 곳이면, 해당 경로를 더해줌.
        if (visited[r][c]) return dp[r][c];
        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            // 방문할 곳의 더 숫자가 낮으면,
            if (inRange(nextR, nextC) && map[nextR][nextC] < map[r][c]) {
                // map[r][c]에서 목적지 까지 갈 수 있는 경로 수 저장.
                dp[r][c] += dfs(nextR, nextC);
                visited[r][c] = true;
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = 0;
        map = new int[m][n];
        dp = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        bw.write(dp[0][0] + "\n");
        bw.flush();
        bw.close();
    }

}
