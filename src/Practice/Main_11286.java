package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11286 {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        // 음수 저장 우선순위 큐 : 절댓값 작은 것 먼저 봐야하므로 내림차순 정렬
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
        // 양수 저장 우선순위 큐
        PriorityQueue<Integer> plus = new PriorityQueue<>();

        // 한쪽 배열이 비어있는 예외처리 하지 않기 위해 최댓값 삽입.
        // MIN_VALUE 는 -(MAX_VALUE)보다 1 더 작음. => 1 더해줌.
        minus.add(Integer.MIN_VALUE + 1);
        plus.add(Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(bf.readLine());
            // 양수일 경우 plus에 넣고 음수일 경우 minus에 넣음.
            if (0 < number)
                plus.add(number);
            else if (number < 0)
                minus.add(number);
            else {
                // 양 쪽 배열이 비어있는 경우 예외처리
                if (minus.size() + plus.size() == 2) {
                    bw.write("0" + "\n");
                    continue;
                }
                // 비교 후 작은 값 뺌.
                if (plus.peek() < -(minus.peek())) {
                    bw.write(plus.poll() + "\n");
                } else
                    bw.write(minus.poll() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
