package BFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_2178 {
    public static int n, m;
    public static int[][] map, dist;
    public static boolean[][] visited;

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        ArrayDeque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0, 0));
        visited[0][0] = true;
        int depth = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            // 단계를 세기 위해 깊이만큼만 뺌.
            for (; 0 < size; size--) {
                Pos cur = deque.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nextR = cur.r + dr[dir];
                    int nextC = cur.c + dc[dir];
                    if (inRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == 1) {
                        visited[nextR][nextC] = true;
                        dist[nextR][nextC] = depth;
                        deque.add(new Pos(nextR, nextC));
                    }
                }
            }
        }
        bw.write(dist[n - 1][m - 1] + "\n");
        bw.flush();
        bw.close();
    }

    public static class Pos {
        public int r;
        public int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
