import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class LAB {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        bw.flush();
//        bw.close();
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.set(s.size() - 1, s.get(s.size() - 1) + 10);
        System.out.println(s.toString());

    }
}