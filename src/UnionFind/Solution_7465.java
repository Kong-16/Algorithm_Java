package UnionFind;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_7465 {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++)
                parent[i] = i;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            int cnt = 0;
            // 루트가 본인이 아닌것 => union 됨. => 같은 그룹이므로 세지 않음.
            for (int i = 1; i <= n; i++) {
                if (parent[i] == i)
                    cnt++;
            }
            bw.write("#" + test_case + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }

}
