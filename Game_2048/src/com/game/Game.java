package com.game;

public class Game {

	private static final double ONE = 0.125;
	private static final double TWO = 0.375;
	private static final double THREE = 0.625;
	private static final double FOUR = 0.875;
	private int numberOfTimes;

	/*
	 * Description: Generates a random number that is either 2 or 4 at the start of
	 * the game
	 * 
	 * Input: No input Output: int representing random number
	 */
	public int initMakeRandomNumber() {
		// Initialization of value1
		int value1 = 0;
		// While loop generating a random value of 2 or 4
		while (true) {
			value1 = (int) (Math.random() * 10);
			if (value1 == 2 || value1 == 4) {
				break;
			}
		}
		return value1;
	}

	/*
	 * Description: Matches x coordinate of tile board position to the corresponding
	 * index in 2d array
	 * 
	 * Input: double representing x coordinate of position on the board Output: int
	 * representing corresponding index in 2d array
	 */
	public int initfindIndexXcoordinate(double cdr) {
		int index = 0;
		if (cdr <= ONE) {
			index = 0;
		} else if (cdr <= TWO) {
			index = 1;
		} else if (cdr <= THREE) {
			index = 2;
		} else {
			index = 3;
		}
		return index;
	}

	/*
	 * Description: Matches y coordinate of tile board position to the corresponding
	 * index in 2d array
	 * 
	 * Input: double representing y coordinate of position on the board Output: int
	 * representing corresponding index in 2d array
	 */
	public int initfindIndexYcoordinate(double cdr) {
		int index = 0;
		if (cdr <= ONE) {
			index = 3;
		} else if (cdr <= TWO) {
			index = 2;
		} else if (cdr <= THREE) {
			index = 1;
		} else {
			index = 0;
		}
		return index;
	}

	

	//( 0 0 0 2 ) -> map[0][3]
	//( 0 0 0 0 ) -------> 0,      3 
	//( 0 0 0 0 ) -------> 0.875   0.875
	//( 0 0 0 0 ) 
	private double findIndexXcoordinate(int x) {
		double index = 0;
		if (x == 0) {
			index = ONE;
		} else if (x == 1) {
			index = TWO;
		} else if (x == 2) {
			index = THREE;
		} else {
			index = FOUR;
		}
		return index;
	}

	private double findIndexYcoordinate(int y) {
		double index = 0;
		if (y == 0) {
			index = FOUR;
		} else if (y == 1) {
			index = THREE;
		} else if (y == 2) {
			index = TWO;
		} else {
			index = ONE;
		}
		return index;
	}

	/*
	 * Description: Generates random coordinate and assigns it to one of the four
	 * static final values (either ONE, TWO, THREE, or FOUR)
	 * 
	 * Input: No input Output: double representing random coordinate
	 */
	public double initFindCoordinate() {
		double cdr = Math.random();
		if (cdr <= ONE) {
			cdr = ONE;
		} else if (cdr <= TWO) {
			cdr = TWO;
		} else if (cdr <= THREE) {
			cdr = THREE;
		} else {
			cdr = FOUR;
		}
		return cdr;
	}

	/*
	 * Description: Takes in int[][] array map and char key (either a,w,s, or d),
	 * returns modified array where the array has moved in the direction of the key
	 * and has appropriately merged tiles with the same value, and checks
	 * termination condition of the game where the grid is full of number tiles and
	 * there is no move possible for the user
	 * 
	 * Input: int[][] array map and char representing the key representing direction
	 * of movement Output: modified int[][] array
	 */
	public int[][] moveTile(int[][] map, char key) {

		/*
		 * Generating another int[][] to check whether any values in the game board has
		 * changed in order to check for the termination condition of defeat
		 */
		int[][] copyMap = new int[4][4];
		copyMap = makeCopyMap(map, copyMap);

		// If statement checking if user presses any one of the keys of a, w, s, or d
		if (key == 'a' || key == 'w' || key == 's' || key == 'd') {

			// When the user presses w (upward direction)
			if (key == 'w') {
				// 1. 위로 움직이는거(완료)
				// 2. 움직이는 않는 경우를 처리하자.

				// 2. 데이터가 있으면 누적시키는거
				// 3. 새로운 값을 만들어내는거

				// 옮길 장소의 index col, row 정보를 가지고 있어야 되고,
				// 데이터를 저장해줘야 되고,

				// Initially, both row and column are at row 0 and column 0 (0,0 in 2d array)
				MoveMap move = new MoveMap(0, 0);

				for (int j = 0; j < 4; j++) { // col
					for (int i = 0; i < 4; i++) { // row
						if (map[i][j] != 0) {
							int moveRow = move.getRow(); // initial row()
							int moveCol = move.getCol(); // initial col()

							// 1. (row, col) 좌표가 맨 끝에 있을 때, shifting 되지 않도록
							// 2. (row, col, value) 그 전에 value와 지금 자리의 value가 같으면 누적.
							// 3. (row, col, value) 그 전에 value와 지금 자리의 value가 같지 않으면 한칸 밑에 값을 옮겨주는거
							// 4. 1번 값이 누적되었다면 그 다음에는 누적되지 않도록 해주기.

							// move.getValue() == 0 아직 아무것도 안했다.
							// move.getValue() != 0 2, 4라던지 값이 변했다.
							// map[i][j] == move.getValue() 둘이 같은 값이면 누적을 시킬거다.
							// !move.isChecked() 1번 누적이 됐으면 그 다음엔 또 누적 x 딱 1번만 2 2 2 2 -> 4 4 0 0

							// Adding up tiles with the same value when they "crash"
							if (move.getValue() != 0 && map[i][j] == move.getValue() && !move.isChecked()) { // 움직이려고
								map[moveRow - 1][moveCol] += map[i][j];
								move = new MoveMap(move.getRow(), move.getCol(), 0, true);
								map[i][j] = 0;

							} else {
								map[moveRow][moveCol] = map[i][j];
								move = new MoveMap(move.getRow() + 1, move.getCol(), map[i][j], false);

							}
							if (i == moveRow && j == moveCol) {
								continue;
							} else {
								map[i][j] = 0;
							}
						}

					}
					move = new MoveMap(0, j + 1);
				}
			}
			// When the user presses a (leftward direction)
			else if (key == 'a') {
				MoveMap move = new MoveMap(0, 0);
				for (int i = 0; i < 4; i++) { // col
					for (int j = 0; j < 4; j++) { // row
						if (map[i][j] != 0) {
							int moveRow = move.getRow(); // initial row()
							int moveCol = move.getCol(); // initial col()
							if (move.getValue() != 0 && map[i][j] == move.getValue() && !move.isChecked()) {
								map[moveRow][moveCol - 1] += map[i][j];
								move = new MoveMap(moveRow, moveCol, 0, true);
								map[i][j] = 0;
							} else {
								map[moveRow][moveCol] = map[i][j];
								move = new MoveMap(move.getRow(), move.getCol() + 1, map[i][j], false);
							}
							if (i == moveRow && j == moveCol) {
								continue;
							} else {
								map[i][j] = 0;
							}
						}
					}
					move = new MoveMap(i + 1, 0);
				}
			}
			// When the user presses s (downward direction)
			else if (key == 's') {
				MoveMap move = new MoveMap(3, 0);
				for (int j = 0; j < 4; j++) { // col
					for (int i = 3; i >= 0; i--) { // row
						if (map[i][j] != 0) {
							int moveRow = move.getRow(); // 변화 전 row()
							int moveCol = move.getCol(); // 변화 전 col()

							if (move.getValue() != 0 && map[i][j] == move.getValue() && !move.isChecked()) { // 움직이려고

								map[moveRow + 1][moveCol] += map[i][j];
								move = new MoveMap(move.getRow(), move.getCol(), 0, true);
								map[i][j] = 0;
							} else {
								map[moveRow][moveCol] = map[i][j];
								move = new MoveMap(move.getRow() - 1, move.getCol(), map[i][j], false);
							}
							if (i == moveRow && j == moveCol) {
								continue;
							} else {
								map[i][j] = 0;
							}
						}
					}
					move = new MoveMap(3, j + 1);

				}
			}
			// When the user presses d (rightward direction)
			else if (key == 'd') {
				MoveMap move = new MoveMap(0, 3);
				for (int i = 0; i < 4; i++) { // row
					for (int j = 3; j >= 0; j--) { // col
						if (map[i][j] != 0) {
							int moveRow = move.getRow();
							int moveCol = move.getCol();
							if (move.getValue() != 0 && map[i][j] == move.getValue() && !move.isChecked()) {
								map[moveRow][moveCol + 1] += map[i][j];
								move = new MoveMap(move.getRow(), move.getCol(), 0, true);
								map[i][j] = 0;
							} else {
								map[moveRow][moveCol] = map[i][j];
								move = new MoveMap(move.getRow(), move.getCol() - 1, map[i][j], false);
							}
							if (i == moveRow && j == moveCol) {
								continue;
							} else {
								map[i][j] = 0;
							}
						}
					}
					move = new MoveMap(i + 1, 3);
				}
			}

			// Compares map and copyMap and increases numberOfTimes if they are different
			if (!isSameMap(map, copyMap)) {
				numberOfTimes++;
				map = newTileNumber(map);
				if (isFinishSuccess(map)) {
					System.out.println("You Win");
				}
			}
			// Prints out "Game Over" when map and copyMap are the same and no tiles can be
			// combined together
			else {
				if (isFinishFail(map)) {
					System.out.println("Game Over");
				}
			}
		}
		return map;
	}

	public double[] checkIndex(int[][] map, int y, int x) {
		double[] indexArray = new double[2];
		// index들이 나타나는 부분이 어디에요? -> isSameMap == false
//		(y,x) 
		indexArray[0] = findIndexYcoordinate(y); //0.875 (0,3)
		indexArray[1] = findIndexXcoordinate(x); //0.875
		return indexArray;
	}

	/*
	 * Description: Helper function generating new tile that is either 2 or 4 after
	 * every turn
	 * 
	 * Input: int[][] map representing the game board Output: modified int[][] with
	 * a new tile
	 */
	private int[][] newTileNumber(int[][] map) {
		int value = initMakeRandomNumber();
		while (true) {
			int x = initfindIndexXcoordinate(initFindCoordinate());
			int y = initfindIndexYcoordinate(initFindCoordinate());
			if (map[y][x] == 0) {
				map[y][x] = value;
				break;
			}
		}
		return map;
	}

	/*
	 * Description: Helper function generating a copy of the game board by creating
	 * an identical 2d array (copyMap)
	 * 
	 * Input: int[][] map representing game board and int[][] copyMap representing a
	 * copy of int[][] map Output: int[][] representing copyMap
	 */
	private int[][] makeCopyMap(int[][] map, int[][] copyMap) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}

	/*
	 * Description: Helper function comparing whether int[][] copyMap and int[][]
	 * map are the same or not
	 * 
	 * Input: int[][] map representing game board and int[][] copyMap representing a
	 * copy of int[][] map Output: boolean operator that shows whether map and
	 * copyMap are different/same
	 */
	private boolean isSameMap(int[][] map, int[][] copyMap) {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] != copyMap[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * Description: Retrieves the number of moves that the player has played
	 * 
	 * Input: No input Output: int numberofTimes representing the number of moves by
	 * the player
	 */
	public int getCount() {
		return numberOfTimes;
	}

	/*
	 * Description: Helper function checking if there are any possible tiles that
	 * can be combined together (if there are any more moves left in the game)
	 * 
	 * Input: int[][] map representing game board Output: boolean operator that
	 * determines whether there are possible moves left in the game
	 * 
	 */
	public boolean isFinishFail(int[][] map) {
		// Declaring variables that represent each direction of movement in row and
		// column
		int[] row = { 0, 0, -1, 1 };
		int[] col = { -1, 1, 0, 0 };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// Checking if there is 0 in the 2d array (corresponding to remaining space on
				// the game board)
				if (map[i][j] == 0) {
					return false;
				}
				for (int idx = 0; idx < 4; idx++) {
					int rowI = i + row[idx];
					int colJ = j + col[idx];

					// Checking if we are out of boundary for the game board
					if (rowI < 0 || colJ < 0 || rowI >= 4 || colJ >= 4) {
						continue;
					}
					/*
					 * Checking if there exists even one number on the board that is the same in any
					 * of the four directions that surround a value on the board such that the two
					 * numbers could combine together
					 */
					if (map[rowI][colJ] == map[i][j]) {
						return false;
					}
				}
			}
		}
		// Boolean operation that represents that the game failure/defeat condition has
		// been met
		return true;
	}

	public boolean isFinishSuccess(int[][] map) {
		// 모든 타일을 탐색해서 (search) 2048이 있는지 찾아내자. -> win(true)
		// 2048이 타일 중에 없다면 -> false;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 2048) {
					return true;
				}
			}
		}
		return false;
	}

}
