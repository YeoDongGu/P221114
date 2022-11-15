package Book;

import java.util.Scanner;

public class ArrayEx20 {

	public static void main(String[] args) {
		final int SIZE = 10;
		int x = 0, y = 0;

		char[][] board = new char[SIZE][SIZE];
		byte[][] shipBoard = { 
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 1, 1, 1, 1, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 1, 0 } 
				};

		for (int i = 1; i < SIZE; i++) {
			board[0][i] = board[i][0] = (char) (i + '0');
		}

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.printf("좌표를 입력하세요.(종료는 00)>");
			String input = sc.nextLine();

			if (input.length() == 2) {
				x = input.charAt(0) - '0';
				y = input.charAt(1) - '0';

				if (x == 0 && y == 0) {
					break;
				}
			}

			if (input.length() != 2 || x <= 0 || x >= SIZE || y <= 0 || y >= SIZE) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
				continue;
			}
			// shipBoard[x-1][y-1] 의 값이 -1 이면 , 'O'을 board[x][y]에 저장한다
			board[x][y] = shipBoard[x - 1][y - 1] == 1 ? 'O' : 'X';

			// 배열 board의 내용을 화면에 출력한다
			for (int i = 0; i < SIZE; i++) {
				System.out.println(board[i]);
			}
			System.out.println();
		}

	}

}
