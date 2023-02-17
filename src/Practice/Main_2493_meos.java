package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2493_meos {
    public static final long HEIGHT2BIGNUM = 1000000;

    public static long getHeight(final long mixed) {
        return mixed / HEIGHT2BIGNUM;
    }

    public static int getIndex(final long mixed) {
        return (int) (mixed % HEIGHT2BIGNUM);
    }

    public static long mix(final long height, final int index) {
        return height * HEIGHT2BIGNUM + index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long[] towers = new long[n];
        for (int i = 0; i < n; i++)
            towers[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Long> deque = new ArrayDeque<>();
        deque.add(mix(1_000_000_000L, 0));
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && getHeight(deque.peekLast()) < towers[i]) {
                deque.pollLast();
            }

            ans.add(getIndex(deque.peekLast()));
            deque.addLast(mix(towers[i], i + 1));
        }

        for (final int index : ans) {
            bw.write(index + " ");
        }

        bw.write("\n");
        bw.flush();
        bw.close();
    }

}
