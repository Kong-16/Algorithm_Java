package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1225 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            bf.readLine();
            int n = 8;
            Deque<Integer> queue = new ArrayDeque<Integer>();

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++)
                queue.add(Integer.parseInt(st.nextToken()));

            int minus = 1;
            for (;;) {
                //맨앞의 요소 추출해서 뺀 뒤 다시 맨 뒤에 넣음.
                // 0이하일 경우 0으로 바꿔서 넣고 반복 종료.
                int tmp = queue.poll() - minus;
                if (tmp <= 0) {
                    queue.add(0);
                    break;
                }
                queue.add(tmp);
                if (++minus == 6)
                    minus = 1;
            }
            bw.write("#" + test_case + " ");
            while (!queue.isEmpty())
                bw.write(queue.poll() + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
