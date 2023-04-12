import java.io.*;
import java.util.Stack;

public class Main_3015 {
    public static class Person {
        public int height;
        public int cnt;

        Person(int h, int c) {
            height = h;
            cnt = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        Stack<Person> stack = new Stack<>();
        stack.push(new Person(Integer.MAX_VALUE, 0));
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            while (stack.peek().height < h) {
                ans += stack.pop().cnt;
            }
            if (stack.peek().height == h) {
                stack.push(new Person(h, stack.pop().cnt + 1));
                if (stack.size() == 2)
                    ans += stack.peek().cnt - 1;
                else
                    ans += stack.peek().cnt;
            } else {
                if (stack.size() != 1)
                    ans += 1;
                stack.push(new Person(h, 1));
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
