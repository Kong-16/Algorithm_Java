package BruteForce;
import java.util.*;
import java.io.*;

public class Main_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] small = new int[9];
        int[] ans = new int[7];
        for (int i = 0; i < 9; i++)
            small[i] = Integer.parseInt(bf.readLine());

        int tall_sum = Arrays.stream(small).sum();
        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                tmp = tall_sum - (small[i] + small[j]);
                if (tmp == 100) {
                    int it = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        ans[it] = small[k];
                        it++;
                    }
                }
            }
            if (tmp == 100)
                break;
        }

        Arrays.sort(ans);

        for (int i = 0; i < 7; i++)
            System.out.println(ans[i]);
    }
}
