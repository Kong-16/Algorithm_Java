package BFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int MAX = 100001;
        int[] dist = new int[MAX];
        Arrays.fill(dist, MAX + 10);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        dist[n] = 0;

        while (!deque.isEmpty()) {
            int pos = deque.pop();
            // 갈 수 있는 범위
            int[] next = new int[]{pos - 1, pos + 1, pos * 2};
            for (int i : next) {
                if (0 <= i && i < MAX) {
                    // 값이 작으면 바꿔줌. 순간이동의 경우 0초이므로 +1 안함.
                    if (i == pos * 2 && dist[pos] < dist[i]) {
                        dist[i] = dist[pos];
                        deque.add(i);
                    } else if (i != pos * 2 && dist[pos] + 1 < dist[i]) {
                        dist[i] = dist[pos] + 1;
                        deque.add(i);
                    }
                }
            }
        }

        bw.write(dist[m] + "\n");
        bw.flush();
        bw.close();
    }
}
