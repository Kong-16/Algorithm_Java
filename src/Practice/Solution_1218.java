package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_1218 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void finish(int test_case, int validity) throws IOException {
        bw.write("#" + test_case + " " + validity + "\n");
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            // { [ ( < 담을 스택들. 닫는 괄호는 넣지않음.
            // Integer보다 메모리가 작은 형으로 선언할 경우 메모리를 더 아낄 수 있을 것이라 예상.
            Stack<Integer> a = new Stack<>();
            Stack<Integer> b = new Stack<>();
            Stack<Integer> c = new Stack<>();
            Stack<Integer> d = new Stack<>();
            int n = Integer.parseInt(bf.readLine());
            String line = bf.readLine();

            loop: for (int i = 0; i < n; i++) {
                switch (line.charAt(i)) {
                    // 여는 괄호일 경우 각각의 스택에 넣음
                    case '{':
                        a.push(1);
                        break;
                    case '[':
                        b.push(1);
                        break;
                    case '(':
                        c.push(1);
                        break;
                    case '<':
                        d.push(1);
                        break;
                    // 닿는 괄호일 경우 해당 스택을 pop 시도.
                    // pop가능할 경우 괄호 한 쌍 완성. 완성된 괄호는 더이상 신경 쓸 필요가 없음.
                    // pop이 불가능할 경우 닫는 괄호가 많은 상태이므로 짝 맞지 않음. 스택에 아무 값이나 넣고 for문 탈출
                    case '}':
                        if (!a.empty())
                            a.pop();
                        else {
                            a.push(1);
                            break loop;
                        }
                        break;
                    case ']':
                        if (!b.empty())
                            b.pop();
                        else {
                            b.push(1);
                            break loop;
                        }
                        break;
                    case ')':
                        if (!c.empty())
                            c.pop();
                        else {
                            c.push(1);
                            break loop;
                        }
                        break;
                    case '>':
                        if (!d.empty())
                            d.pop();
                        else {
                            d.push(1);
                            break loop;
                        }
                        break;
                }
            }
            // 스택이 비어있지 않은 경우 여는 괄호가 많은 상태 + 닫는 괄호가 많아 for문을 탈출한 상태.
            if (!a.empty() || !b.empty() || !c.empty() || !d.empty()) {
                finish(test_case, 0);
            } else
                finish(test_case, 1);
        }
        bw.flush();
        bw.close();
    }

}
