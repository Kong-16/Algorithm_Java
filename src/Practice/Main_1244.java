package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1244 {
    public static boolean[] arr = new boolean[103];
    public static int n;

    // 처음 본인 위치 포함
    // 양 옆 비교 후 같으면 부호 바꿈.
    public static void girl(int num) {
        int mNum = num;
        arr[num] = !arr[num];
        while (arr[num] == arr[mNum]) {
            arr[num] = !arr[num++];
            arr[mNum] = !arr[mNum--];
            // arr의 끝에 닿으면 이후 연산 실행하지 않음.
            if (mNum == 0 || num == n + 1)
                break;
        }
    }
    //num의 배수의 스위치 바꿈
    public static void boy(int num) {
        for (int i = num; i < arr.length; i += num)
            arr[i] = !arr[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(bf.readLine());
        arr = new boolean[n + 1];
        st = new StringTokenizer(bf.readLine());

        // 0 과 1 만 사용하므로 boolean으로 받음
        // 스위치 번호 시작이 1부터이므로 1부터 받음
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        int m = Integer.parseInt(bf.readLine());
        for (int p = 0; p < m; p++) {
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1)
                boy(num);
            else
                girl(num);
        }
        for (int i = 0; i < n; i++) {
            if (i != 0 && i % 20 == 0)
                sb.append("\n");
            sb.append((arr[i + 1] ? 1 : 0) + " ");

        }
        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
    }

}