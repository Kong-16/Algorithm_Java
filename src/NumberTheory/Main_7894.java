package NumberTheory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_7894 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int length = 10000000;
        int[] ans = new int[length + 1];
        double fact = 1;
        // 자릿수가 크기때문에 로그의 합으로 바꿔줌
        for (int i = 1; i <= length; i++) {
            fact = fact + Math.log10(i);
            ans[i] = (int) fact;
        }
        for (int t = 0; t < n; t++) {
            int m = Integer.parseInt(br.readLine());
            bw.write((int) ans[m] + "\n");
        }

        bw.flush();
        bw.close();
    }

}
