/*
 * 다익스트라
 */
package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_dijkstra {
    public static int v;
    public static int e;
    public static int k;
    public static int[] dist;
    public static ArrayList<Edge>[] graph;

    public static class Edge implements Comparable<Edge> {
        public int from;
        public int to;
        public int weight;

        Edge(int f, int t, int w) {
            from = f;
            to = t;
            weight = w;
        }

        @Override
        public int compareTo(Edge a) {
            return this.weight - a.weight;
        }
    }

    public static void dijkstra(int s) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, s, 0));
        while (!pq.isEmpty()) {
            Edge u = pq.poll();
            for (Edge e : graph[u.to]) {
                if (e.weight + u.weight < dist[e.to]) {
                    dist[e.to] = e.weight + u.weight;
                    pq.add(new Edge(e.from, e.to, dist[e.to]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        dist = new int[v];
        graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(from, to, weight));
        }
        dijkstra(k - 1);

        for (int i = 0; i < v; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                bw.write("INF" + "\n");
            else
                bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

}
