//package UnionFind;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Solution_2636 {
//    public static class DisjointSet {
//        public final int[] parents;
//
//        public DisjointSet(final int N) {
//            parents = new int[N];
//        }
//
//        public int find(final int u) {
//            if (parents[u] != u) {
//                parents[u] = find(parents[u]);
//            }
//            return parents[u];
//        }
//
//        public
//    }
//
//    public static void main(final String[] args) throws IOException {
//        try (final BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {
//            final int H, W;
//            {
//                final String[] tokens = stdin.readLine().split(" ");
//                H = Integer.parseInt(tokens[0]);
//                W = Integer.parseInt(tokens[1]);
//            }
//
//            final int[][] m = new int[H][W];
//            for (int y = 0; y < H; ++y) {
//                final String[] tokens = stdin.readLine().split(" ");
//                for (int x = 0; x < W; ++x) {
//                    m[y][x] = Integer.parseInt(tokens[x]);
//                }
//            }
//
//        }
//    }
//}
