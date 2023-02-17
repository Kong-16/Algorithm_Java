package TwoPointer;
/*
 * 새로운 알파벳이 들어오면 count를 증가시킴.
 * count가 n보다 커지면, 작아질 때 까지 queue에서 뺌.
 * queue의 길이 = 알파벳의 길이
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        Deque<Character> alpha = new ArrayDeque<>();

        int maxLength = 0;
        int count = 0;
        for (int e = 0; e < str.length(); e++) {
            char cur = str.charAt(e);
            if (alpha.contains(cur)) {
                alpha.add(cur);
                maxLength = Math.max(maxLength, alpha.size());
            } else {
                count++;
                while (n < count) {
                    if (!alpha.contains(alpha.poll()))
                        count--;
                }
                alpha.add(cur);
                maxLength = Math.max(maxLength, alpha.size());
            }
        }
        bw.write(maxLength + "\n");
        bw.flush();
        bw.close();
    }

}
