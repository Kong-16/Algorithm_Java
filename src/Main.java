import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int c = Integer.parseInt(bf.readLine());
        for (int test_case = 0; test_case < c; test_case++) {
            st = new StringTokenizer(bf.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Long> prefix = new ArrayList<>();
            Map<Long, Long> map = new HashMap<>();
            prefix.add(0L);
            long cnt = 0;
            st = new StringTokenizer(bf.readLine());
            for (int i = 1; i < n; i++) {
                prefix.add(prefix.get(i - 1) + Integer.parseInt(st.nextToken()));
                if (n % d == 0)
                    cnt++;
                int k = d;
                while (k <= prefix.get(i)) {
                    if (map.containsKey(prefix.get(i) - k))
                        cnt++;
                    k *= d;
                }
                map.put(prefix.get(i), map.getOrDefault(prefix.get(i), 0L) + 1);
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }

}