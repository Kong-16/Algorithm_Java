package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2493 {
    // tower의 인덱스와 높이 저장할 class
    public static class Tower {
        public int index;
        public int height;

        Tower(int i, int h) {
            index = i;
            height = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] tower = new int[n + 1];
        tower[0] = Integer.MAX_VALUE;
        Deque<Tower> deque = new ArrayDeque<>();
        Deque<Integer> ans = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            tower[i] = Integer.parseInt(st.nextToken());
        // 초깃값에 Integer.MAX_VALUE 넣어 스택이 비었는지 확인할 필요 없앰.
        deque.addLast(new Tower(0, tower[0]));

        for (int i = 1; i <= n; i++) {
            Tower tmp = new Tower(i, tower[i]);
            // 보고있는 값보다 큰 값이 나올 때 까지 stack에서 pop
            while (deque.peekLast().height < tower[i]) {
                deque.pollLast();
            }
            // 해당 탑은 스택의 top에 닿음. 저장.
            ans.addLast(deque.peekLast().index);
            deque.addLast(tmp);
        }
        for (int idx : ans) {
            bw.write(idx + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

}
