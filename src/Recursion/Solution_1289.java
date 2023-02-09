package Recursion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
 * 이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution_1289 {

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        /*
         * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
         */

        for (int test_case = 1; test_case <= T; test_case++) {
            int cnt = 0;
            char button = '0';
            char[] ans = bf.readLine().toCharArray();
            // 비트 반전 시 이후 모든 비트 반전 됨. => button으로 지정.
            // => button과 ans 비교해서 다르면 button 반전후 cnt++
            for (int i = 0; i < ans.length; i++) {
                if (button != ans[i]) {
                    cnt++;
                    if (button == '1')
                        button = '0';
                    else
                        button = '1';
                }
            }
            bw.write("#" + test_case + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}