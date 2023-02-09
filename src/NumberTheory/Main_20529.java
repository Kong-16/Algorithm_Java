package NumberTheory;
/*
 * 완전 탐색, 세 쌍을 선택해 모두 검사함.
 * mbti 종류는 16종류.
 * 비둘기집의 원리에 의해 n이 32명 이상 들어올 경우
 * mbti가 같은 사람이 최소 세 명 있음 => 답 0
 *  
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_20529 {
    public static int gap(char[] a1, char[] a2, char[] a3) {
        int gap = 0;
        for (int i = 0; i < 4; i++) {
            if (a1[i] != a2[i])
                gap++;
            if (a1[i] != a3[i])
                gap++;
            if (a2[i] != a3[i])
                gap++;
        }
        return gap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());
        for (int test_case = 0; test_case < t; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            if (n > 32) {
                bw.write(0 + "\n");
                st = new StringTokenizer(bf.readLine());
                continue;
            }
            st = new StringTokenizer(bf.readLine());
            char[][] arr = new char[n][4];
            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken().toCharArray();
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        ans = Math.min(ans, gap(arr[i], arr[j], arr[k]));
                    }
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
    }

}
