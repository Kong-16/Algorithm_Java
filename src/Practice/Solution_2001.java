package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2001 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] prefix = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 1; j <= n; j++) {
                    prefix[i][j] = Integer.parseInt(st.nextToken()) + prefix[i - 1][j] + prefix[i][j - 1]
                            - prefix[i - 1][j - 1];
                }
            }
            int maxNum = Integer.MIN_VALUE;
            // 크기가 m x m 인 부분 합 완전탐색으로 구함.
            // arr[i][j]까지의 합 - (j - m)까지의 합(왼쪽) - (i -m)까지의 합(위쪽)
            // 부분합을 빼는 과정에서 중복으로 빠지는 부분이 있으므로 다시 더해줌.
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int area = prefix[i + m][j + m] - prefix[i][j + m] - prefix[i + m][j] + prefix[i][j];
                    maxNum = Math.max(maxNum, area);
                }
            }
            bw.write("#" + test_case + " " + maxNum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
