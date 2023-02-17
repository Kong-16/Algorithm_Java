import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_bliz {
    public static int n;
    public static int m;
    public static int r;
    public static int sharkPos;
    public static int[] explode = new int[3];
    public static int[][] field;
    public static Deque<Integer> bids;
    public static int[] dxIce = { 0, -1, 1, 0, 0 };
    public static int[] dyIce = { 0, 0, 0, -1, 1 };
    public static int[] dxBid = { 0, 1, 0, -1 };
    public static int[] dyBid = { -1, 0, 1, 0 };

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void field2Bids() {
        bids.clear();
        int x = sharkPos;
        int y = sharkPos;
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;
        int dir = 0;
        while (x + y != 0) {
            x = (x + dxBid[dir] + 50 * n) % n;
            y = (y + dyBid[dir] + 50 * n) % n;

            if (field[x][y] > 0)
                bids.add(field[x][y]);
            visited[x][y] = true;
            int nextX = (x + dxBid[(dir + 1) % 4] + 50 * n) % n;
            int nextY = (y + dyBid[(dir + 1) % 4] + 50 * n) % n;
            if (!visited[nextX][nextY]) {
                dir = (dir + 1) % 4;
            }
        }
    }

    public static void bids2Field() {
        int x = sharkPos;
        int y = sharkPos;
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;
        Deque<Integer> tmp = new ArrayDeque<>();
        int dir = 0;
        // int it = 0;
        while (x + y != 0) {
            x = (x + dxBid[dir] + 50 * n) % n;
            y = (y + dyBid[dir] + 50 * n) % n;
            // field[x][y] = it < bids.size() ? bids.get(it++) : 0;
            if (!bids.isEmpty()) {
                field[x][y] = bids.peek();
                tmp.add(bids.poll());
            } else
                field[x][y] = 0;
            visited[x][y] = true;
            int nextX = (x + dxBid[(dir + 1) % 4] + 50 * n) % n;
            int nextY = (y + dyBid[(dir + 1) % 4] + 50 * n) % n;
            if (!visited[nextX][nextY]) {
                dir = (dir + 1) % 4;
            }
        }
        bids = tmp;
    }

    public static void throwIce(int dir, int s) {
        int x = sharkPos;
        int y = sharkPos;
        for (int i = 0; i < s; i++) {
            x = (x + dxIce[dir] + 50 * n) % n;
            y = (y + dyIce[dir] + 50 * n) % n;
            if (inRange(x, y)) {
                explode[field[x][y] + 1]++;
                field[x][y] = 0;
            }
        }
        field2Bids();
        bids2Field();
    }

    public static void explodeBids() {
        int numEqual = 0;
        int count = 0;
        Deque<Integer> tmp = new ArrayDeque<>();

        for (int i = 0; i < bids.size(); i++) {
            int num = bids.poll();
            if (num == numEqual)
                count++;
            else {
                for (int j = 0; j < count; j++) {
                    tmp.add(numEqual);
                }
                x
                numEqual = num;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        field = new int[n][n];
        bids = new ArrayDeque<>();
        sharkPos = n / 2;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        field2Bids();
        bids2Field();
        System.out.println(bids.toString());
        System.out.println(Arrays.deepToString(field));
        bw.flush();
        bw.close();
    }
}
