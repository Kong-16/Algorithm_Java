import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    public static int N;
    public static int answer = 0;
    public static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N + 1];
        setQueen(1);
        System.out.println(answer);
    }

    public static boolean isAvailable(int rowNo) {
        for (int i = 1; i <= N; i++) {
            if()
        }
    }
    private static void setQueen(int rowNo) {
        if (!isAvailable(rowNo - 1))
            return;
        if (rowNo > N) {
            answer += 1;
            return;
        }
        for (int c = 1; c <= N; c++) {
            col[rowNo] = c;
            setQueen(rowNo + 1);
        }
    }

}
