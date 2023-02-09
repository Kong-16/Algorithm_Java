package PriorityQueue;

/* 우선순위 큐 두 개 선언 (minHeap, maxHeap)
 * 첫 입력 ㅣ ans
 * 이후 입력 ans와 비교 후 ans보다 크면 minHeap, 작으면 maxHeap에 add
 * 두 힙 길이 비교 후 길이가 맞지 않으면 ans는 작은 쪽 heap에 add, 긴 쪽 heap에서 pop 해서 ans로 저장.
 * maxHeap - ans(중간값) - maxHeap
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        int ans = Integer.parseInt(bf.readLine());
        bw.write(ans + "\n");
        for (int call = 1; call < n; call++) {
            int in = Integer.parseInt(bf.readLine());
            if (ans < in) {
                minPq.add(in);
            } else {
                maxPq.add(in);
            }
            if (minPq.size() > maxPq.size() + 1) {
                maxPq.add(ans);
                ans = minPq.poll();
            } else if (maxPq.size() > minPq.size()) {
                minPq.add(ans);
                ans = maxPq.poll();
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();

    }

}
