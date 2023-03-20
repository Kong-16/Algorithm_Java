package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_6987 {
    // 결과 값 저장
    public static int[][] result;
    // 경기 결과 비교 할 테이블. table을 result로 만들어줌
    public static int[][] table;

    // table이 result보다 작으면 가능한 경우.
    public static boolean isPromising(int home, int homeRes, int away, int awayRes) {
        if (result[home][homeRes] < table[home][homeRes] || result[away][awayRes] < table[away][awayRes])
            return false;
        return true;
    }

    // dfs로 리그의 모든 경기 돌려봄.
    public static boolean dfs(int home, int away, int round) {
        if (away == 6) {
            if (home == 5)
                // 마지막에 도달했을 때. true 반환
                return true;
            return dfs(home + 1, home + 2, round);
        }

        // 각각 이겼을 때, 비겼을 때, 졌을 때, 시도해봄.
        for (int i = 0; i < 3; i++) {
            table[home][i]++;
            table[away][2 - i]++;
            if (isPromising(home, i, away, 2 - i)) {
                if (dfs(home, away + 1, round + 1)) {
                    return true;
                }
            }
            table[home][i]--;
            table[away][2 - i]--;
        }
        // 모든 경우에서 불가능할 경우 false
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = 4;
        for (int test_case = 0; test_case < t; test_case++) {
            result = new int[6][3];
            table = new int[6][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean isValid = true;
            for (int i = 0; i < 6; ++i) {
                int total = 0;
                for (int j = 0; j < 3; ++j) {
                    total += result[i][j];
                }

                if (total != 5) {
                    isValid = false;
                    break;
                }
            }

            bw.write((isValid && dfs(0, 1, 1) ? 1 : 0) + " ");
        }

        bw.flush();
        bw.close();

    }

}
