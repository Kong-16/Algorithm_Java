package Lecture;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_1210 {
	public static int[][] arr = new int[102][102];
	public static int col = 0;
	public static int row = 99;

	public static void move(int dir) { // 막대의 끝에 닿을 때 까지 좌, 우로 이동.
		while (arr[row][col + dir] == 1)
			col += dir;
		row--;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			bf.readLine(); // test_case 번호. 쓸 일 없어서 버림.
			arr = new int[102][102];
			row = 99;
			col = 0;
			for (int i = 1; i <= 100; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 1; j <= 100; j++)
				if (arr[100][j] == 2) // X표시인 부분부터 사다리를 타고 위로 올라감.
					col = j;
			while (row != 1) { // arr가 가장 위 까지 도달할 때의 위치 출력.
				if (arr[row][col + 1] == 1) // 가로 막대를 만났을 때, 막대 끝 까지 가는 move 실행
					move(1);
				else if (arr[row][col - 1] == 1)
					move(-1);
				else
					row--;
			}
			bw.write("#" + test_case + " " + (col - 1) + "\n");
		}

		bw.flush();
		bw.close();
	}
}