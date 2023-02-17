package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686 {
    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int m;
    public static int ans = Integer.MAX_VALUE;
    public static int[][] city;

    // 조합을 위해 방문 체크
    public static boolean[] visited;
    // 폐업하지 않은 치킨집
    public static Pair[] survive;
    public static ArrayList<Pair> chicken;
    public static ArrayList<Pair> house;

    public static int getDist(Pair c, Pair h) {
        return Math.abs(c.x - h.x) + Math.abs(c.y - h.y);
    }

    public static void combine(int depth, int it) {
        // 조합 완료 시 최소 거리 구함.
        if (depth == m) {
            int sum = 0;
            for (Pair h : house) {
                int minDist = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    minDist = Math.min(minDist, getDist(h, survive[i]));
                }
                sum += minDist;
            }
            ans = Math.min(ans, sum);
        }
        for (int i = it; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                Pair tmp = chicken.get(i);
                survive[depth] = new Pair(tmp.x, tmp.y);
                combine(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1)
                    house.add(new Pair(i, j));
                else if (city[i][j] == 2)
                    chicken.add(new Pair(i, j));
            }
        }
        visited = new boolean[chicken.size()];
        survive = new Pair[chicken.size()];

        combine(0, 0);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }

}