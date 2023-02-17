package Practice;

import java.util.*;

public class Main_2563 {

    public static void main(String[] args) {
        try (
                Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int[][] area = new int[101][101];

            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                // j부터 ~+10 k부터 ~+10 색칠함
                for (int j = a; j < a + 10; j++) {
                    for (int k = b; k < b + 10; k++) {
                        area[j][k] = 1;
                    }
                }
            }

            int sum = 0;
            // 색칠된 범위 체크
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (area[i][j] == 1)
                        sum++;
                }
            }

            System.out.println(sum);
        }
    }
}