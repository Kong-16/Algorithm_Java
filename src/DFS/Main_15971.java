package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15971 {
    public static int n, start, end;
    public static ArrayList<Edge>[] graph;
    public static boolean[] visited;
    public static int[] cost;

    public static class Edge {
        public int from;
        public int to;
        public int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dfs(int cur, int total, int max) {
        // 중복 방지
        if (visited[cur]) return;
        // 만나는 통로는 거리에 더하지 않음. => 경로 중 최댓값 한 번 뺌. (그 통로에서 만남)
        if (cur == end) {
            cost[cur] -= max;
            return;
        }


        visited[cur] = true;
        // 갈 수 있는 모든 통로들 가봄.
        for (Edge e : graph[cur]) {
            cost[e.to] = total + e.weight; // 덮어 씌워질 일 없음
            dfs(e.to, total + e.weight, Math.max(max, e.weight));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        visited = new boolean[n + 1];
        cost = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(from, to, weight));
            graph[to].add(new Edge(to, from, weight));
        }
        dfs(start, 0, 0);
        bw.write((cost[end]) + "\n");
        bw.flush();
        bw.close();
    }
}