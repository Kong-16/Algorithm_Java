package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2961 {
    public static boolean[] isSelected;
    public static int[][] arr;
    public static int n;
    public static int min_num;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        isSelected = new boolean[n];
        arr = new int[n][2];

        // 신맛과 쓴맛을 각각 저장할 2차원 배열 생성
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        min_num = Integer.MAX_VALUE;
        generateSubset(0);
        bw.write(min_num + "\n");
        bw.flush();
        bw.close();
    }

    public static void generateSubset(int cnt) {
        // 재귀 종료 조건. 모든 원소를 다 체크했을 때
        if (cnt == n) {
            int s = 1;
            int b = 0;
            // 신맛 = 곱 쓴맛 = 합
            for (int i = 0; i < n; i++) {
                if (isSelected[i]) {
                    s *= arr[i][0];
                    b += arr[i][1];
                }
            }
            // 모두 포함되지 않았을 때를 체크하기 위한 비트
            boolean isContains = false;
            for (int i = 0; i < n; i++) {
                if (isSelected[i]) {
                    isContains = true;
                    break;
                }
            }
            // 하나라도 포함 돼있다면 최솟값 계산
            if (isContains)
                min_num = Math.min(min_num, Math.abs(s - b));
            return;
        }
        // arr[cnt]를 선택한 경우
        isSelected[cnt] = true;
        generateSubset(cnt + 1);
        // 선택하지 않은 경우에 대해 각각 재귀문을 돌려줌.
        isSelected[cnt] = false;
        generateSubset(cnt + 1);
    }

}
