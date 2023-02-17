package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_1233_공민혁 {
    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T;
        T = 10;
        
        //사칙연산 저장.
        String operators = "-+*/";

        for (int test_case = 1; test_case <= T; test_case++) {
            boolean possible = true;
            int n = Integer.parseInt(bf.readLine());
            int i = 0;
            //마지막 level 전까지는 연산자만 나와야함.
            for (; i < (n - 1) / 2; i++) {
                st = new StringTokenizer(bf.readLine());
                st.nextToken();
                // 연산자 / 숫자
                String token = st.nextToken();
                
                //연산자가 아니면 사칙연산 성립되지않음.
                if (!operators.contains(token))
                    possible = false;
            }
            //이후엔 숫자만 나와야함.
            for (; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                st.nextToken();
                String token = st.nextToken();
                if (operators.contains(token))
                    possible = false;
            }
            bw.write("#" + test_case + " ");
            if (possible)
                bw.write(1 + "\n");
            else
                bw.write(0 + "\n");
        }
        bw.flush();
        bw.close();
    }
}