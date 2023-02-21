package DFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3109 {
    public static int r;
    public static int c;
    public static boolean[][] field;
    // 가장 위쪽으로 가보는 경우가 최적의 경로이므로 위, 중간, 아래 순으로 탐색함.
    public static int[] dx = { -1, 0, 1 };

    public static boolean inRange(int x) {
        return x < r && 0 <= x;
    }

    public static boolean move(int x, int y) {
        // 마지막에 도달할 경우. => 갈 수 있음.
        if (y == c - 1)
            return true;
        for (int dir = 0; dir < 3; dir++) {
            int nextX = x + dx[dir];
            // 다음 방향 가봄.
            if (inRange(nextX) && field[nextX][y + 1]) {
                // 갈 수 있을 경우 감. 다른 파이프는 이동하지 못하므로 길 막음.
                field[nextX][y + 1] = false;
                // 다음 칸으로 가봄. 갈 수 있을 경우 true를 반환할 수 있게 함.
                if (move(nextX, y + 1))
                    return true;
            }
        }
        // 가지 못할 경우 false 반환
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        field = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                field[i][j] = (str.charAt(j) == '.' ? true : false);
            }
        }
        int ans = 0;
        // 모든 열에 대해 시도.
        for (int i = 0; i < r; i++) {
            // 가능하면 파이프 생성.
            ans += (move(i, 0) ? 1 : 0);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

}
