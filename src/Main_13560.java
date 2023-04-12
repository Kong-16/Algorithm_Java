import java.io.*;
import java.util.StringTokenizer;

public class Main_13560 {
    public static int n, m;
    public static Pos red, blue;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static char map[][], ws[][];

    public static class Pos {
        public int r;
        public int c;
        public boolean isin = false;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void dfs(int curDir, int cnt) {
        if (cnt == 10)
            return;
        tilt(curDir);
        for (int nextDir = 0; nextDir < 4; nextDir++) {
            if (nextDir != curDir) dfs(nextDir, cnt + 1);
        }
    }

    public static void tilt(int dir) {
        switch (dir) {
            // 한쪽 방향으로 기울일 경우
            // 그 쪽 방향으로부터 가까이 있는 공 먼저 움직임.
            case 0:
                if (red.r < blue.r) {
                    move(red, blue, dir);
                } else {
                    move(blue, red, dir);
                }
                break;
            case 1:
                if (blue.c < red.c) {
                    move(blue, red, dir);
                } else {
                    move(red, blue, dir);
                }
                break;
            case 2:
                if (blue.r < red.r) {
                    move(blue, red, dir);
                } else {
                    move(red, blue, dir);
                }
                break;
            case 3:
                if (red.c < blue.c) {
                    move(red, blue, dir);
                } else {
                    move(blue, red, dir);
                }
                break;
        }
    }

    public static void move(Pos first, Pos second, int dir) {
        first.isin = false;
        int firstR = first.r + dr[dir];
        int firstC = first.c + dc[dir];

        while (map[firstR][firstC] != '#') {
            if (map[firstR][firstC] == 'O') {
                first.r = 0;
                first.c = 0;
                first.isin = true;
                break;
            }
            firstR = first.r + dr[dir];
            firstC = first.c + dc[dir];
        }
        first.r = firstR;
        first.c = firstC;

        second.isin = false;
        int secondR = second.r;
        int secondC = second.c;
        while (map[secondR][secondC] == '.') {
            secondR = second.r + dr[dir];
            secondC = second.c + dc[dir];
        }
        if (map[secondR][secondC] == 'O') {
            second.isin = true;
        }
        second.r = secondR;
        second.c = secondC;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        ws = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                ws[i][j] = map[i][j];
                if (map[i][j] == 'R')
                    red = new Pos(i, j);
                else if (map[i][j] == 'B')
                    blue = new Pos(i, j);
            }
        }
    }
}
