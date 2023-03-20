package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_1238 {
    public static boolean[][] adjMatrix;
    public static boolean[] visited;
    public static int maxP = 101;
    public static int ans;

    public static int bfs(int s) {
        visited = new boolean[maxP];
        // 깊이 별로 최댓 값을 구해야하므로 이전단계의 방문노드와 현재단계의 방문노드 저장 큐 분리
        ArrayDeque<Integer> connection = new ArrayDeque<>();
        ArrayDeque<Integer> prev = new ArrayDeque<>();
        // 첫 노드 방문 처리
        visited[s] = true;
        connection.add(s);
        // bfs 종료조건. 이전단계 방문 노드에서 아무 것도 전달해주지 않았을 때 (모두 방문)
        while (!connection.isEmpty()) {
            // 현재 단계의 노드 모두 옮김.
            while (!connection.isEmpty()) {
                prev.add(connection.poll());
            }
            int tmpMax = 0;
            // 이전 단계에서 방문한 모든 노드에 대해서
            while (!prev.isEmpty()) {
                int p = prev.poll();
                // 구간 별 최대 값 저장.
                tmpMax = Math.max(tmpMax, p);
                // 갈 수 있는 모든 노드를 다음 큐에 넣음.
                for (int i = 0; i < maxP; i++) {
                    if (!visited[i] && adjMatrix[p][i]) {
                        connection.add(i);
                        // 방문 처리
                        visited[i] = true;
                    }
                }
            }
            // 방문 단계별로 ans가 구간의 최댓값으로 초기화 됨.
            ans = tmpMax;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = 10;
        for (int test_case = 1; test_case <= t; test_case++) {
            adjMatrix = new boolean[maxP][maxP];
            visited = new boolean[maxP];
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to] = true;
            }
            bfs(start);
            bw.write("#" + test_case + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }
}
