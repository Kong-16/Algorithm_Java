package NumberTheory;
/*
 * 전체 시간의 합의 약수를 구함.
 * 잔 시간의 max값 아래의 약수는 계산 할 필요 없음.
 * 잔 시간의 누적 합 배열 생성
 * 남은 약수에 대해 : prefix를 순회
 * prefix가 약수 k의 배수 보다 작으면 합침
 * 크면 다음 약수로 넘어감
 * 같으면 k의 다음 배수로 넘어감.
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14476 {

    public static void factorialize(int n, PriorityQueue<Integer> fact) {
        if (n == 0) {
            fact.add(0);
            return;
        }

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                fact.add(i);
                if (i != n / i) {
                    fact.add(n / i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(bf.readLine());
        for (int test_case = 0; test_case < k; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            ArrayList<Integer> arr = new ArrayList<Integer>();
            ArrayList<Integer> prefix = new ArrayList<Integer>();
            PriorityQueue<Integer> fact = new PriorityQueue<Integer>();
            prefix.add(0);
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int sum = 0;
            int max_num = 0;
            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                max_num = Math.max(max_num, tmp);
                sum += tmp;
                arr.add(tmp);
                prefix.add(sum);
            }
            factorialize(prefix.get(n), fact);
            while (fact.peek() < max_num)
                fact.poll();
            while (!fact.isEmpty()) {
                int cnt = 0;
                int mul = fact.poll();
                int next = mul;
                for (int i = 1; i <= n; i++) {
                    if (prefix.get(i) > next)
                        break;
                    else if (prefix.get(i) < next)
                        cnt++;
                    else {
                        next += mul;
                    }
                }
                if (next - mul == prefix.get(n)) {
                    bw.write(cnt + "\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
