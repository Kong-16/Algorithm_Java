package DFS;

import java.io.*;
import java.util.*;

public class Main_2668 {
    public static int n;
    public static int[] graph;
    public static boolean[] visited;
    public static Set<Integer> set, ans;

    public static int dfs(int cur) {
        if (visited[cur]) {
            return cur;
        }
        visited[cur] = true;
        int tmp = dfs(graph[cur]);
        // dfs를 빠져나오면서 set에 숫자를 넣음.
        set.add(cur);
        // 싸이클이 시작하는 순간까지 오면 set의 모든 원소가 cycle을 형성함.
        // 이후엔 ans에 set의 원소를 넣지 않으므로 cycle을 돌지 않는 정점은 반영안됨.
        if (cur == tmp) {
            for (int i : set)
                ans.add(i);
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1];
        visited = new boolean[n + 1];
        ans = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            set = new HashSet<>();
            dfs(i);
        }
        bw.write(ans.size() + "\n");
        ArrayList<Integer> sortedAns = new ArrayList<>(ans);
        Collections.sort(sortedAns);
        for (int i : sortedAns) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();

    }
}
