package Prefix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] prefix = new int[n + 1][n + 1];

        //prefix에 [1][1] 에서 시작하는 부분 행렬의 합 저장. ex) prefix[2][2] = prefix[1][1] + prefix[1][2] + prefix[2][1] + prefix[2][2]
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++)
                // 위의 부분합과 왼쪽 부분합을 더하면 중복해서 더해지는 부분이 있어서 빼줌.
                prefix[i][j] = Integer.parseInt(st.nextToken()) + prefix[i][j - 1] + prefix[i - 1][j]
                        - prefix[i - 1][j - 1];
        }

        // x2,y2의 부분행렬에서 x1-1까지의 부분행렬과 y1-1 까지의 부분행렬을 빼야함.
        // 중복해서 빼지는 부분 다시 더해줌.
        for (int test_case = 0; test_case < m; test_case++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = prefix[x2][y2] - prefix[x2][y1 - 1] - prefix[x1 - 1][y2] + prefix[x1 - 1][y1 - 1];
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}