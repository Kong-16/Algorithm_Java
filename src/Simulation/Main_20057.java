package Simulation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20057 {
    public static int n;
    public static int sandSum = 0;

    public static int[][] field;
    public static int[][][] blowArr = {
            {
                    { 0, 0, 2, 0, 0 },
                    { 0, 10, 7, 1, 0 },
                    { 5, 0, 0, 0, 0 },
                    { 0, 10, 7, 1, 0 },
                    { 0, 0, 2, 0, 0 }
            },
            {
                    { 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 2, 7, 0, 7, 2 },
                    { 0, 10, 0, 10, 0 },
                    { 0, 0, 5, 0, 0 }
            },
            {
                    { 0, 0, 2, 0, 0 },
                    { 0, 1, 7, 10, 0 },
                    { 0, 0, 0, 0, 5 },
                    { 0, 1, 7, 10, 0 },
                    { 0, 0, 2, 0, 0 }
            },
            {
                    { 0, 0, 5, 0, 0 },
                    { 0, 10, 0, 10, 0 },
                    { 2, 7, 0, 7, 2 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 0, 0, 0, 0 }
            }
    };
    public static int[] dx = { 0, 1, 0, -1 };
    public static int[] dy = { -1, 0, 1, 0 };

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void move() {
        int x = n / 2;
        int y = n / 2;
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;
        int dir = 0;
        while (x + y != 0) {
            x = (x + dx[dir] + 500 * n) % n;
            y = (y + dy[dir] + 500 * n) % n;
            calSpread(x, y, dir);
            visited[x][y] = true;
            int nextX = (x + dx[(dir + 1) % 4] + 500 * n) % n;
            int nextY = (y + dy[(dir + 1) % 4] + 500 * n) % n;
            if (!visited[nextX][nextY]) {
                dir = (dir + 1) % 4;
            }
        }
    }

    public static void calSpread(int x, int y, int dir) {
        int sand = field[x][y];
        int[][] workSpace = new int[5][5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                workSpace[i][j] = sand * blowArr[dir][i][j] / 100;
                sum += workSpace[i][j];
            }
        }
        field[x][y] = 0;
        workSpace[2 + dx[dir]][2 + dy[dir]] = sand - sum;
        addSand(workSpace, sand, x, y);

    }

    public static void addSand(int[][] workSpace, int sum, int x, int y) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (inRange(x + i - 2, y + j - 2)) {
                    field[x + i - 2][y + j - 2] = workSpace[i][j] + field[x + i - 2][y + j - 2];
                } else
                    sandSum += workSpace[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        field = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move();
        bw.write(sandSum + "\n");
        bw.flush();
        bw.close();

    }
}
