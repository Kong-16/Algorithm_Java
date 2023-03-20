package Greedy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String query = br.readLine();
        int e = query.length();
        int s = e - 1;
        int ans = 0;
        int tmp = 0;
        // 연산자 앞, 뒤를 다 봐야함 => 뒤에서 부터 읽음.
        // 그리디. - 오기전까지 수를 다 더한뒤, -를 만나면 정답에서 빼줌.
        while (0 < s--) {
            switch (query.charAt(s)) {
                case '+':
                    tmp += Integer.parseInt(query.substring(s + 1, e));
                    e = s;
                    break;
                case '-':
                    tmp += Integer.parseInt(query.substring(s + 1, e));
                    ans -= tmp;
                    tmp = 0;
                    e = s;
                    break;
            }
        }

        // 가장 앞에 +가 있다고 가정. (맨 처음 수 더해줌)
        tmp += Integer.parseInt(query.substring(0, e));
        ans += tmp;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }

}
