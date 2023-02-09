package Lecture;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_2805 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());

        // 마름모 =>
        // 각 행에 대해 중앙 기준 열의 갯수 - 2 * (i와 n / 2 의 차이의 갯수) 만큼 더하면 됨
        // j가 mid 에서 (mid - j) 만큼 멀어지면 안 더함.
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            int[][] arr = new int[n + 1][n + 1];
            int sum = 0;
            int mid = n / 2;
            for (int i = 0; i < n; i++) {
                String str = bf.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                    if (j <= 2 * mid - Math.abs(mid - i) && j >= Math.abs(mid - i)) {
                        sum += arr[i][j];
                    }
                }
            }
            bw.write("#" + test_case + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }

}
