import java.io.*;
import java.util.ArrayList;

public class Main_1519 {
    public static String str;
    public static int n;
    public static int[] dp;

    public static ArrayList<Integer> split() {
        ArrayList<Integer> numArr = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j <= (str.length() - i); j++) {
                String tmp = str.substring(j, j + i);
                if (!tmp.equals("0"))
                    numArr.add(Integer.parseInt(tmp));
            }
        }
        return numArr;
    }

    public static int getDp(int idx) {
        if (dp[idx] != 0)
            return dp[idx];
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        n = Integer.parseInt(str);
        dp = new int[n];
        for (int i = 1; i < 10; i++) {
            dp[i] = 100000000;
        }
        ArrayList<Integer> numArr = split();
        int ans = Integer.MAX_VALUE;
        for (int num : numArr) {
            ans = Math.max(dp[num], ans);
        }
        System.out.println(numArr.toString());
    }
}
