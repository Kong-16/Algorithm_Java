package DP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class colorApt {
    public static int n = 8;
    public static boolean[] apt;
    public static int cnt = 0;

    // 노란색으로 칠한 경우 false, 파란색으로 칠한 경우 true
    public static void dfs(int depth, boolean prevIsBlue) {
        if (depth == n) {
            cnt++;
            return;
        }
        // 노란색으로 칠함.
        apt[depth] = false;
        dfs(depth + 1, apt[depth]);
        // 이전에 파란색으로 칠했을 경우 파란색으로는 칠하지 않음.
        if (!prevIsBlue) {
            apt[depth] = true;
            dfs(depth + 1, apt[depth]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        apt = new boolean[n];
        dfs(0, false);
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
