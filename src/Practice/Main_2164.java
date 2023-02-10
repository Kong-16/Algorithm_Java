package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            deque.add(i);
        // 큐에서 하나 뽑아서 삭제 후 다시 뒤에 넣음.
        // 하나 남을 때 까지 반복
        while (deque.size() > 1) {
            deque.poll();
            deque.add(deque.poll());
        }
        bw.write(deque.poll() + "\n");
        bw.flush();
        bw.close();
    }
}