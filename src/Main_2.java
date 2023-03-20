import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;

class Main_2 {
    public static int n;
    public static String[] strs;
    public static char[] alphabets;
    public static StringBuilder sb = new StringBuilder();
    // 뒤에서부터 넣으므로 stack 사용.
    public static Stack<String> strStack = new Stack<>();

    public static void findAlphabets(String alphabet) {
        // 쪼갠 문자열을 저장할 deque의 배열.
        ArrayDeque<String>[] partStr = new ArrayDeque[n];
        for (int i = 0; i < n; i++) {
            partStr[i] = new ArrayDeque<>();
            String copyStr = strs[i];
            int s = 0;
            int e = copyStr.indexOf(alphabet);
            // 처음 나온 문자 전까지 슬라이싱 해서 원본 문자열에 넣음.
            e = e > -1 ? e : copyStr.length();
            strs[i] = copyStr.substring(s, e);
            s = e;
            int tmp = s;
            // 해당 문자가 연속해서 있을 경우, 해당 문자열은 통째로 묶음.
            while (s < copyStr.length()) {
                e = copyStr.indexOf(alphabet, s + 1);
                // while (e > -1 && copyStr.charAt(tmp) == copyStr.charAt(e)) {
                // e = copyStr.indexOf(alphabet, tmp + 1);
                // tmp++;
                // }
                e = e > -1 ? e : copyStr.length();
                partStr[i].addFirst(copyStr.substring(s, e));
                s = e;
                tmp = s;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(partStr[i].toString());
        }
        boolean notEmpty = true;
        // 모든 부분문자열이 비워져있으면 종료.
        while (notEmpty) {
            notEmpty = false;
            // 대문자 A~Z보다 작은 문자 넣음.
            String maxStr = "(";
            int minIdx = -1;
            for (int i = 0; i < n; i++) {
                if (!partStr[i].isEmpty()) {
                    notEmpty = true;
                    // concat 시도해서 더 큰 값 저장.
                    String a = partStr[i].peek();
                    String tmpA = a.concat(maxStr);
                    String tmpB = maxStr.concat(a);
                    if (0 < tmpA.compareTo(tmpB)) {
                        minIdx = i;
                        maxStr = a;
                    }
                }
            }
            // 가장 큰 값을 정답 stack에 넣음.
            if (minIdx > -1)
                strStack.push(partStr[minIdx].poll());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        strs = new String[n];
        alphabets = new char[26];
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }
        for (int i = 0; i < 26; i++) {
            alphabets[i] = (char) (90 - i);
            char alpha = (char) (90 - i);
            String alphabet = Character.toString(alpha);
            findAlphabets(alphabet);
        }
        while (!strStack.empty()) {
            sb.append(strStack.pop());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}