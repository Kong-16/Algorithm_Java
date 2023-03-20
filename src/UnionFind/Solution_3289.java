package UnionFind;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3289 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;
    public static int[] parent;

    // 루트를 같게 해줌. 루트끼리만 합쳐야하므로 find로 서로의 루트를 찾은 뒤 병합.
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB)
            return;
        parent[rootA] = parent[rootB];
    }

    // parent[i]가 i가 아니라면, (본인이 루트가 아닌 경우) 루트를 찾아 올라감.
    // 이 과정에서 이후의 연산을 줄이기 위해 parent[i]를 루트의 값으로 바꿔줌.
    public static int find(int i) {
        if (parent[i] == i)
            return i;
        else
            return parent[i] = find(parent[i]);
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case + " ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = new int[n + 1];
            for (int i = 0; i < n; i++)
                parent[i] = i;
            for (int input = 0; input < m; input++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (op == 0)
                    union(a, b);
                else {
                    if (find(a) == find(b))
                        sb.append(1);
                    else
                        sb.append(0);
                }
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
