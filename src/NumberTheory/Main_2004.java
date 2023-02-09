package NumberTheory;
/*
 * nCm 구하기
 * 일반적인 방법으로 구할 경우 시간제한에 걸림
 * 0의 개수를 구하는 문제이므로 10의 약수의 갯수 구하기
 * n! / (n-m)! * m! 에서 2와 5의 갯수 구한 뒤 최솟값
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2004 {
    public static int getFactMul(int factorial, int divisor) {
        int weight = 0;
        while (factorial >= divisor) {
            weight += factorial / divisor;
            factorial /= divisor;
        }
        return weight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int five_num = getFactMul(n, 5) - getFactMul(n - m, 5) - getFactMul(m, 5);
        int two_num = getFactMul(n, 2) - getFactMul(n - m, 2) - getFactMul(m, 2);
        int ans = Math.min(five_num, two_num);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
