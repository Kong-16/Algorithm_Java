package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_5658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<String> password = new ArrayList<>();
            String str = br.readLine();
            ArrayDeque<String> deque = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++)
                deque.add(str.substring(i, i + 1));
            HashSet<String> pass = new HashSet<>();

            for (int w = 0; w < n / 4; w++) {
                for (int i = 0; i < 4; i++) {
                    String tmp = "";
                    for (int j = 0; j < n / 4; j++) {
                        String a = deque.poll();
                        tmp = tmp.concat(a);
                        deque.add(a);
                    }
                    pass.add(tmp);
                }
                deque.add(deque.poll());
            }
            for (String s : pass) {
                password.add(s);
            }
            password.sort(Collections.reverseOrder());
            String a = password.get(k - 1);
            int ans = Integer.parseInt(password.get(k - 1), 16);
            bw.write("#" + test_case + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}