package DP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        int[][] knapsack = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (weight[i] <= j) {
                    knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i - 1][j - weight[i]] + value[i]);
                } else {
                    knapsack[i][j] = knapsack[i - 1][j];
                }
            }
        }
        bw.write(knapsack[n][k] + "\n");
        bw.flush();
        bw.close();
    }
}
