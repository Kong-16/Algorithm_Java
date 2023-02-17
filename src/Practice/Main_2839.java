package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());

        int nCopy = n % 5;
        int five = n / 5;
        int three = 0;
        // 일단 5를 최대한 담은 뒤,
        // 3이 안들어가면 5를 하나씩 빼고 3을 넣어봄.
        while (nCopy <= n) {
            if (nCopy % 3 == 0) {
                three = nCopy / 3;
                break;
            } else {
                nCopy += 5;
                five--;
            }
        }
        if (n < nCopy)
            bw.write(-1 + "\n");
        else
            bw.write(five + three + "\n");
        bw.flush();
        bw.close();
    }

}
