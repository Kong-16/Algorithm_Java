package Simulation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_21610 {
    public static int n;
    public static int m;
    public static int[][] field;
    public static int[][] workspace;
    public static boolean[][] exist;
    public static ArrayList<Integer> cloud;
    public static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
    public static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
    public static int[] dx2 = { -1, -1, 1, 1 };
    public static int[] dy2 = { -1, 1, 1, -1 };

    public static void synchronizeExist() {
        exist = new boolean[n][n];
        for (int pos : cloud) {
            exist[pos / n][pos % n] = true;
        }
    }

    public static void synchronizeCloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (exist[i][j] && !cloud.contains((i * n) + j)) {
                    cloud.add((n * i) + j);
                }
            }
        }
    }

    public static void synchronizefield() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = workspace[i][j];
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void moveCloud(int dir, int magnitude) {
        for (int i = 0; i < cloud.size(); i++) {
            int pos = cloud.get(i);
            int x = pos / n;
            int y = pos % n;
            x = (x + (dx[dir] * magnitude) + (51 * n)) % n;
            y = (y + (dy[dir]) * magnitude + (51 * n)) % n;
            workspace[x][y]++;
            cloud.set(i, (x * n) + y);
        }
        synchronizeExist();
        synchronizefield();
    }

    public static void copyWater() {
        for (int pos : cloud) {
            int x = pos / n;
            int y = pos % n;
            for (int i = 0; i < 4; i++) {
                int xTemp = x + dx2[i];
                int yTemp = y + dy2[i];
                if (inRange(xTemp, yTemp) && field[xTemp][yTemp] > 0)
                    workspace[x][y]++;
            }
        }
        synchronizefield();
    }

    public static void water2Cloud() {
        ArrayList<Integer> newCloud = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (2 <= field[i][j] && !cloud.contains((i * n) + j)) {
                    newCloud.add((n * i) + j);
                    field[i][j] -= 2;
                }
            }
        }
        cloud = newCloud;
        synchronizeExist();
    }

    public static void combine(int dir, int magnitude) {
        moveCloud(dir, magnitude);
        copyWater();
        water2Cloud();
        cloud.clear();
        synchronizeExist();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        field = new int[n][n];
        workspace = new int[n][n];
        exist = new boolean[n][n];
        cloud = new ArrayList<Integer>();
        for (int i = n - 2; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                exist[i][j] = true;
                synchronizeCloud();
            }
        }

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; ++j) {
                field[i][j] = Integer.parseInt(st.nextToken());
                workspace[i][j] = field[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            combine(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += field[i][j];
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
