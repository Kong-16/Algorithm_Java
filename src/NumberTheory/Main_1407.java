package NumberTheory;
/* A~B까지 2의 최대 거듭제곱의 합
 * divisor = 2^max : B보다 작은 2의 최대 거듭제곱
 * B / divisor : 1 ~ B 까지 중에 divisor 이 몇 개가 있는지.
 * (B / divisor) - (A / divisor) : A ~ B 까지 중에 divisor 몇 개 있는지
 * 이걸 divisor = 2^max 부터 2^0 까지 반복해야함.
 * 그러면 겹쳐서 빠지는 부분 존재. ex) 16의 배수와 8의 배수는 16의 배수에서 겹침.
 * prev = divisor * 2 : 이전에 뺀 거듭제곱 제외
 * ((B / divisor) - (B / prev)): divisor이 최대 거듭제곱인 수가 1 ~ B 사이에 몇 개 있는지
 * (((B / divisor) - (B / prev)) - ((A / divisor) - (A / prev))) A ~ B 사이
 *  * divisor 하면 A ~ B사이 divisor이 최대 거듭제곱인 수의 합.
 *  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1407 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(st.nextToken()) - 1;
        long b = Long.parseLong(st.nextToken());
        long sum = 0;

        long prev = 1;
        int cnt = 0;
        while (prev <= b) {
            prev *= 2;
            cnt++;
        }
        long biggest = prev / 2;
        // b의 n의 약수의 개수 = (b / n) - (b / prev)
        // prev 는 이전에 수행한 n의 약수의 개수
        // ex) 8만으로 떨어지는 숫자를 찾을 때는 16으로만 떨어지는 숫자를 빼야함.
        for (int i = cnt; i > 0; i--) {
            sum += (((b / biggest) - (b / prev)) - ((a / biggest) - (a / prev))) * biggest;
            prev /= 2;
            biggest /= 2;
        }
        System.out.println(sum);

    }
}
