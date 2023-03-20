import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] idx = new int[n];
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            strings[i] = input;
        }
        // char maxChar = (char) 90;
        // String maxStr = Character.toString(maxChar);
        int maxIdx = 0;
        int s = 0;
        int e = 1;
        for (int i = 0; i < n; i++) {
            String maxStr = strings[maxIdx].substring(s, e);
            int cmp = maxStr.compareTo(strings[i].substring(s, e));
            while (cmp != 0) {
                e++;
            }
            if (cmp < 0) {
                maxIdx = i;
            }
        }
        sb.append(strings[maxIdx].substring(s, e));
        strings[maxIdx] = strings[maxIdx].substring(e);
    }
}
