package DP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class colorStick {
    public static int n;
    public static int[][] colorstick;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = 6;
        colorstick = new int[2][n + 2];
        // 파랑, 노랑 막대 칠함.
        colorstick[0][0] = 2;
        // 빨간 막대는 두 칸이므로 한 칸 뒤에 칠함.
        colorstick[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            // 1칸짜리 칠하는 경우. 두 개씩 더함.
            colorstick[0][i] = 2 * (colorstick[0][i - 1] + colorstick[1][i - 1]);
            // 2칸짜리 칠하는 경우. 한 칸 뒤에 칠해줌.
            colorstick[1][i + 1] = colorstick[0][i - 1] + colorstick[1][i - 1];
        }
        cnt = colorstick[0][n - 1] + colorstick[1][n - 1];
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
