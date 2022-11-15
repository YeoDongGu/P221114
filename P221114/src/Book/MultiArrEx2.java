package Book;

import java.util.Scanner;

public class MultiArrEx2 {

	public static void main(String[] args) {
		final int SIZE = 5;

		int x = 0, y = 0, num = 0, num2 = 0;
		int bCount = 0;
		int p1sCount = 0;
		int p2sCount = 0;

		int[][] bingo = new int[SIZE][SIZE];
		Scanner sc = new Scanner(System.in);
		// 배열의 모든 요소를 1부터 SIZE*SIZE 까지의 숫자로 초기화

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				bingo[i][j] = i * SIZE + j + 1;
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				x = (int) (Math.random() * SIZE);
				y = (int) (Math.random() * SIZE);

				// bingo[i][j] 와 임의로 선택된 값 (bingo[x][y]) 을 바꾼다.

				int tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
			}
		}

		while (true) {

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.printf("%2d ", bingo[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			System.out.printf("첫번째 플레이어 : 1~%d의 숫자를 입력하세요. (종료:0)>", SIZE * SIZE);
			String tmp = sc.nextLine(); // 화면에서 입력받은 내용을 tmp에 저장
			num = Integer.parseInt(tmp); // 입력받은 문자열(tmp)를 숫자로 변환

			// 입력받은 숫자와 같은 숫자가 저장된 요소를 찾아서 0을 저장
			outer1: for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (bingo[i][j] == num) {
						bingo[i][j] = 0;
						break outer1;
					}
				}
			}

			for (int i = 0; i < SIZE; i++) {

				// 가로빙고 체크

				for (int j = 0; j < SIZE; j++) {
					if (bingo[i][j] == 0) {
						bCount++;
					}
					if (bCount == 5) {
						++p1sCount;
						bCount = 0;
					}

				}
				bCount = 0;
				// 세로빙고 체크
				for (int j = 0; j < SIZE; j++) {
					if (bingo[j][i] == 0) {
						bCount++;
					}
					if (bCount == 5) {
						++p1sCount;
						bCount = 0;
					}
				}
				bCount = 0;
			}
			// 대각선 빙고 체크
			if (bingo[0][0] == 0 && bingo[1][1] == 0 && bingo[2][2] == 0 && bingo[3][3] == 0 && bingo[4][4] == 0) {
				p1sCount++;
			}
			if (bingo[0][4] == 0 && bingo[1][3] == 0 && bingo[2][2] == 0 && bingo[3][1] == 0 && bingo[4][0] == 0) {
				p1sCount++;
			}

			// 1번 플레이어가 빙고 성공시 프로그램 종료
			if (p1sCount == 1) {
				System.out.println("1번 플레이어가 승리하셨습니다.");
				break;
			}

// 2번플레이어 입력
// ====================================================================================================================

			System.out.printf("두번쨰 플레이어 : 1~%d의 숫자를 입력하세요. (종료:0)>", SIZE * SIZE);
			String tmp2 = sc.nextLine(); // 화면에서 입력받은 내용을 tmp2에 저장
			num2 = Integer.parseInt(tmp2); // 입력받은 문자열(tmp2)를 숫자로 변환

			// 입력받은 숫자와 같은 숫자가 저장된 요소를 찾아서 -1을 저장
			outer2: for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (bingo[i][j] == num2) {
						bingo[i][j] = -1;
						break outer2;
					}
				}
			}
			for (int i = 0; i < SIZE; i++) {

				// 가로빙고 체크

				for (int j = 0; j < SIZE; j++) {
					if (bingo[i][j] == -1) {
						bCount++;
					}
					if (bCount == 5) {
						++p2sCount;
						bCount = 0;
					}

				}
				bCount = 0;
				// 세로빙고 체크
				for (int j = 0; j < SIZE; j++) {
					if (bingo[j][i] == -1) {
						bCount++;
					}
					if (bCount == 5) {
						++p2sCount;
						bCount = 0;
					}
				}
				bCount = 0;
			}
			// 대각선 빙고 체크
			if (bingo[0][0] == -1 && bingo[1][1] == -1 && bingo[2][2] == -1 && bingo[3][3] == -1 && bingo[4][4] == -1) {
				p2sCount++;
			}
			if (bingo[0][4] == -1 && bingo[1][3] == -1 && bingo[2][2] == -1 && bingo[3][1] == -1 && bingo[4][0] == -1) {
				p2sCount++;
			}

			// 0 이나 -1 이 입력되면 프로그램 종료
			if (num == 0 || num == -1 || num2 == 0 || num2 == -1) {
				break;
			}

			// 2번 플레이어가 빙고 성공시 프로그램 종료
			if (p2sCount == 1) {
				System.out.println("2번 플레이어가 승리하셨습니다.");
				break;
			}
			p1sCount = 0;
			p2sCount = 0;
		}
		sc.close();
	}

}
