import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public static void main(String args[]) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            int[][] arr = new int[n][n];
            int i = 0;
            int j = 0;
            int num = 1;
            int dir = 0;
            int[][] vector = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
            while (num <= n) {
                arr[i + vector[dir][0]][j + vector[dir][1]] = num++;
                System.out.println(i + vector[dir][0]);
                if (arr[i + vector[dir][0]][j + vector[dir][1]] != 0 || i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    if (dir++ == 4)
                        dir = 0;
                }
            }
            bw.write("#" + test_case + "\n");
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    bw.write(arr[a][b] + " ");
                }
                bw.write("\n");
            }

        }
        bw.flush();
        bw.close();
    }
}
