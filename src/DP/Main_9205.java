package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_9205 {
    public static int n;
    public static int[][] vertex;
    public static ArrayList<Edge>[] graph;
    public static int[] dist;
    public static int max = 10000000;

    public static class Edge implements Comparable<Edge> {
        public int from;
        public int to;
        public int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static void dijkstra(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist = new int[n];
        Arrays.fill(dist, max);
        dist[s] = 0;
        pq.add(new Edge(s, s, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for (Edge e : graph[cur.to]) {
                if (cur.weight + e.weight < dist[e.to]) {
                    dist[e.to] = cur.weight + e.weight;
                    pq.add(new Edge(e.from, e.to, dist[e.to]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine()) + 2;
            vertex = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                vertex[i][0] = Integer.parseInt(st.nextToken());
                vertex[i][1] = Integer.parseInt(st.nextToken());
            }
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int distance = Math.abs(vertex[i][0] - vertex[j][0]) + Math.abs(vertex[i][1] - vertex[j][1]);
                    if (distance <= 1000) {
                        graph[i].add(new Edge(i, j, 0));
                        graph[j].add(new Edge(j, i, 0));
                    }
                }
            }
            dijkstra(0);
            if (dist[n - 1] != max) bw.write("happy" + "\n");
            else bw.write("sad" + "\n");
        }
        bw.flush();
        bw.close();
    }
}
