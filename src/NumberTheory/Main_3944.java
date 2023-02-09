package NumberTheory;

/*
 * b진법 수에 대해 b^n % (b-1) = 1
 * => 매 자릿수 더해서 b-1로 나누기
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3944 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int b = Integer.parseInt(st.nextToken()) - 1;
            String number = st.nextToken();
            int sum = 0;
            for (int j = 0; j < number.length(); j++) {
                sum += number.charAt(j) - '0';
            }
            bw.write(sum % b + "\n");
        }
        bw.flush();
        bw.close();
    }
}
