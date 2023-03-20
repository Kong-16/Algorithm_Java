package Greedy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrList = new ArrayList<>();
        int[] arr = new int[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        int length = n - k;
        deque.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (!deque.isEmpty() && deque.peekLast() < arr[i]) {
                while (!deque.isEmpty() && deque.peekLast() < arr[i] && 0 < k) {
                    deque.pollLast();
                    k--;
                }
            }
            deque.add(arr[i]);
            if (k < deque.size()) {
                arrList.add(deque.pollFirst());
            }
        }
        while (!deque.isEmpty()) {
            arrList.add(deque.pollFirst());
        }
        for (int i = 0; i < length; i++) {
            bw.write(arrList.get(i) + "");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
