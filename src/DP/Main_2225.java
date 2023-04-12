package DP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // sum[i][j] = 연산을 i번 했을 때 n을 만들 수 있는 경우의 수.
        int[][] sum = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            sum[i][1] = i;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
                // 오버플로우 방지를 위해 10억으로 나눠줌.
                sum[i][j] %= 1000000000;
            }
        }
        bw.write(sum[k][n] + "\n");
        bw.flush();
        bw.close();
    }

}
