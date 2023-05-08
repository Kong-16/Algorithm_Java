package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2568 {
    public static int n, lastIdx;
    public static int[][] dp;
    public static int[][] line;
    public static int[] prev;

    public static int binarySearch(int find) {
        int idx = 0;
        int start = 0;
        int end = lastIdx;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (find < dp[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
                idx = mid;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        //dp[][1] 에 이전 값의 인덱스 저장. => 해당 수가 어떤 값에서 더해져서 dp[][0]이 되었는지 표시.
        dp = new int[n + 1][2];
        line = new int[n][2];
        //이전 인덱스 저장. 역추적 위함.
        prev = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }
        // line[][0] 을 기준으로 정렬 한 뒤 LIS 찾음.
        Arrays.sort(line, (a, b) -> {
            return a[0] - b[0];
        });

        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = -1;
        lastIdx = 0;

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(line[i][1]);
            dp[idx + 1][0] = line[i][1];
            dp[idx + 1][1] = i;
            if (idx == lastIdx) lastIdx++;
            prev[i] = dp[idx][1];
        }
        bw.write((n - lastIdx) + "\n");
        int idx = dp[lastIdx][1];
        while (0 <= idx) {
            // 방문처리
            int tmp = idx;
            idx = prev[idx];
            prev[tmp] = -10;
        }
        for (int i = 0; i < n; i++) {
            if (-1 <= prev[i]) bw.write(line[i][0] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
