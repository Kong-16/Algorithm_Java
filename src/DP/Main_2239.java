package DP;

import java.io.*;
import java.util.Arrays;

public class Main_2239 {
    public static int n;
    public static int[] row;
    public static int[] col;
    public static int[][] square;
    public static int[][] sudoku;
    public static StringBuilder sb;

    public static void write() throws IOException {

    }

    public static void dfs(int r, int c) throws IOException {
        if (c == n) {
            // 종료조건. 끝까지 다 왔을 때
            // 출력 완료 후 다음 재귀로 가지 않기 위해 시스템 종료.
            if (r == n - 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sb.append(sudoku[i][j]);
                    }
                    sb.append("\n");
                }
                System.out.println(sb.toString());
                System.exit(0);
            }
            // c가 끝까지 오면 다음 행 채우러감.
            dfs(r + 1, 0);
            return;
        }
        if (sudoku[r][c] == 0) {
            for (int number = 1; number <= n; number++) {
                // sudoku[r][c]에 number가 있는지 확인 후 없으면 넣어봄.
                if (isPromising(r, c, number)) {
                    sudoku[r][c] = number;
                    dfs(r, c + 1);
                    sudoku[r][c] = 0;
                }
            }
        } else
            dfs(r, c + 1);
    }

    public static boolean isPromising(int r, int c, int number) {
        // 가로, 세로에 같은 숫자 있는지 확인.
        for (int i = 0; i < n; i++) {
            if (sudoku[r][i] == number)
                return false;
            if (sudoku[i][c] == number)
                return false;
        }
        int squaredRow = (r / 3) * 3;
        int squaredCol = (c / 3) * 3;
        // r,c를 포함하는 사각형에 같은 숫자 있는지 확인.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[squaredRow + i][squaredCol + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        n = 9;
        sudoku = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                sudoku[i][j] = str.charAt(j) - '0';
            }
        }
        dfs(0, 0);
    }
}