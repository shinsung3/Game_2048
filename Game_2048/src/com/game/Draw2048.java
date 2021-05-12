package com.game;

import java.util.Arrays;

public class Draw2048 {

	// Declaring static final variable for width of square for each tile on game
	// board
	private static final double WIDTH = 0.125;

	public static void main(String[] args) {
		Game g = new Game();
		// Creating 2d array with the name map for 2048 game board
		int[][] map = new int[4][4];

		// Declaring variables for x and y coordinates in game board
		double x1 = g.initFindCoordinate();
		int x1Index = g.initfindIndexXcoordinate(x1);
		double y1 = g.initFindCoordinate();
		int y1Index = g.initfindIndexYcoordinate(y1);
		double x2 = 0.0;

		/*
		 * Two random values generated at the start of the game are located at different
		 * coordinates on the game board
		 */
		while (true) {
			x2 = g.initFindCoordinate();
			if (x1 != x2) {
				break;
			}
		}

		int x2Index = g.initfindIndexXcoordinate(x2);
		double y2 = g.initFindCoordinate();
		int y2Index = g.initfindIndexYcoordinate(y2);

		map[y1Index][x1Index] = g.initMakeRandomNumber();
		map[y2Index][x2Index] = g.initMakeRandomNumber();

		// Drawing 1st Row Squares
		PennDraw.setPenColor(226, 140, 59);
		PennDraw.filledSquare(0.125, 0.875, WIDTH);
		PennDraw.filledSquare(0.375, 0.875, WIDTH);
		PennDraw.filledSquare(0.625, 0.875, WIDTH);
		PennDraw.filledSquare(0.875, 0.875, WIDTH);

		// Drawing 2nd Row Squares
		PennDraw.filledSquare(0.125, 0.625, WIDTH);
		PennDraw.filledSquare(0.375, 0.625, WIDTH);
		PennDraw.filledSquare(0.625, 0.625, WIDTH);
		PennDraw.filledSquare(0.875, 0.625, WIDTH);

		// Drawing 3rd Row Squares
		PennDraw.filledSquare(0.125, 0.375, WIDTH);
		PennDraw.filledSquare(0.375, 0.375, WIDTH);
		PennDraw.filledSquare(0.625, 0.375, WIDTH);
		PennDraw.filledSquare(0.875, 0.375, WIDTH);

		// Drawing 4th Row Squares
		PennDraw.filledSquare(0.125, 0.125, WIDTH);
		PennDraw.filledSquare(0.375, 0.125, WIDTH);
		PennDraw.filledSquare(0.625, 0.125, WIDTH);
		PennDraw.filledSquare(0.875, 0.125, WIDTH);

		// Drawing vertical lines
		PennDraw.setPenRadius(0.02);
		PennDraw.setPenColor(150, 146, 132);
		PennDraw.line(0.25, 1, 0.25, 0);
		PennDraw.line(0.5, 1, 0.5, 0);
		PennDraw.line(0.75, 1, 0.75, 0);

		// Drawing horizontal lines
		PennDraw.line(0, 0.75, 1, 0.75);
		PennDraw.line(0, 0.5, 1, 0.5);
		PennDraw.line(0, 0.25, 1, 0.25);

		// Drawing entire square representing game board
		PennDraw.setPenColor(150, 146, 132);
		PennDraw.square(0.5, 0.5, 0.5);

		// Establishing miscellaneous setup for game board
		// x1, y1
		if (map[y1Index][x1Index] == 2) {
			PennDraw.setPenColor(PennDraw.RED);
		} else if (map[y1Index][x1Index] == 4) {
			PennDraw.setPenColor(PennDraw.ORANGE);
		}
		PennDraw.filledSquare(x1, y1, WIDTH);
		
		// x2, y2
		if (map[y2Index][x2Index] == 2) {
			PennDraw.setPenColor(PennDraw.RED);
		} else if (map[y2Index][x2Index] == 4) {
			PennDraw.setPenColor(PennDraw.ORANGE);
		}
		PennDraw.filledSquare(x2, y2, WIDTH);

		PennDraw.setPenColor(PennDraw.BLACK);
		PennDraw.setFontSize(30);
		PennDraw.setFontBold();

		// Drawing two randomly generated values on the initial game board
		PennDraw.text(x1, y1, Integer.toString(map[y1Index][x1Index]));
		PennDraw.text(x2, y2, Integer.toString(map[y2Index][x2Index]));

		for (int[] a : map)
			System.out.println(Arrays.toString(a));

		while (true) {
			if (PennDraw.hasNextKeyTyped()) {
				char key = PennDraw.nextKeyTyped();
				map = g.moveTile(map, key);

				// ->1회 움직이고 난 뒤에 while(true) loop 안에서 그림을 그리고, 위치를 찍고, 변화를 줄거에요.

				System.out.println(g.getCount());
//				PennDraw.clear();
				PennDraw.setPenColor(226, 140, 59);
				PennDraw.filledSquare(0.125, 0.875, WIDTH);
				PennDraw.filledSquare(0.375, 0.875, WIDTH);
				PennDraw.filledSquare(0.625, 0.875, WIDTH);
				PennDraw.filledSquare(0.875, 0.875, WIDTH);

				// Drawing 2nd Row Squares
				PennDraw.filledSquare(0.125, 0.625, WIDTH);
				PennDraw.filledSquare(0.375, 0.625, WIDTH);
				PennDraw.filledSquare(0.625, 0.625, WIDTH);
				PennDraw.filledSquare(0.875, 0.625, WIDTH);

				// Drawing 3rd Row Squares
				PennDraw.filledSquare(0.125, 0.375, WIDTH);
				PennDraw.filledSquare(0.375, 0.375, WIDTH);
				PennDraw.filledSquare(0.625, 0.375, WIDTH);
				PennDraw.filledSquare(0.875, 0.375, WIDTH);

				// Drawing 4th Row Squares
				PennDraw.filledSquare(0.125, 0.125, WIDTH);
				PennDraw.filledSquare(0.375, 0.125, WIDTH);
				PennDraw.filledSquare(0.625, 0.125, WIDTH);
				PennDraw.filledSquare(0.875, 0.125, WIDTH);

				// Drawing vertical lines
				PennDraw.setPenRadius(0.005);
				PennDraw.setPenColor(150, 146, 132);
				PennDraw.line(0.25, 1, 0.25, 0);
				PennDraw.line(0.5, 1, 0.5, 0);
				PennDraw.line(0.75, 1, 0.75, 0);

				// Drawing horizontal lines
				PennDraw.line(0, 0.75, 1, 0.75);
				PennDraw.line(0, 0.5, 1, 0.5);
				PennDraw.line(0, 0.25, 1, 0.25);

				// Drawing entire square representing game board
				PennDraw.setPenColor(150, 146, 132);
				PennDraw.square(0.5, 0.5, 0.5);
//				map = new int[][] { { 2048, 4, 8, 16 }, { 64, 2, 32, 128 }, { 256, 1028, 8, 16 }, { 4, 2, 4, 8 } };
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (map[i][j] != 0) {
							double[] indexArray = g.checkIndex(map, i, j);
							// indexArray[0] = y -> 0.875
							// indexArray[1] = x -> 0.875
							if (map[i][j] == 2) {
								PennDraw.setPenColor(PennDraw.RED);
							} else if (map[i][j] == 4) {
								PennDraw.setPenColor(PennDraw.ORANGE);
							} else if (map[i][j] == 8) {
								PennDraw.setPenColor(PennDraw.PINK);
							} else if (map[i][j] == 16) {
								PennDraw.setPenColor(PennDraw.MAGENTA);
							} else if (map[i][j] == 32) {
								PennDraw.setPenColor(PennDraw.LIGHT_GRAY);
							} else if (map[i][j] == 64) {
								PennDraw.setPenColor(PennDraw.GREEN);
							} else if (map[i][j] == 128) {
								PennDraw.setPenColor(PennDraw.GRAY);
							} else if (map[i][j] == 256) {
								PennDraw.setPenColor(PennDraw.CYAN);
							} else if (map[i][j] == 512) {
								PennDraw.setPenColor(PennDraw.BOOK_RED);
							} else if (map[i][j] == 1024) {
								PennDraw.setPenColor(PennDraw.BOOK_LIGHT_BLUE);
							} else if (map[i][j] == 2048) {
								PennDraw.setPenColor(PennDraw.BLUE);
							}
							PennDraw.filledSquare(indexArray[1], indexArray[0], WIDTH);
							// Drawing vertical lines
							PennDraw.setPenRadius(0.005);
							PennDraw.setPenColor(150, 146, 132);
							PennDraw.line(0.25, 1, 0.25, 0);
							PennDraw.line(0.5, 1, 0.5, 0);
							PennDraw.line(0.75, 1, 0.75, 0);

							// Drawing horizontal lines
							PennDraw.line(0, 0.75, 1, 0.75);
							PennDraw.line(0, 0.5, 1, 0.5);
							PennDraw.line(0, 0.25, 1, 0.25);
							PennDraw.setPenColor(PennDraw.BLACK);
							PennDraw.setFontSize(30);
							PennDraw.setFontBold();
							PennDraw.text(indexArray[1], indexArray[0], Integer.toString(map[i][j]));
						}
					}
				}
				if (g.isFinishSuccess(map)) {
					PennDraw.picture(0.5, 0.5, "victory.jpg");
					PennDraw.setPenColor(PennDraw.RED);
					PennDraw.setFontSize(60);
					PennDraw.setFontBold();
					PennDraw.text(0.45, 0.4, Integer.toString(g.getCount()));
					break;
				} else {
					if (g.isFinishFail(map)) {
						PennDraw.picture(0.5, 0.5, "defeat.jpg");
						PennDraw.setPenColor(PennDraw.BLUE);
						PennDraw.setFontSize(60);
						PennDraw.setFontBold();
						PennDraw.text(0.45, 0.4, Integer.toString(g.getCount()));
						break;
					}
				}

				// This is for testing purposes
				System.out.println(">>>>>>KEY<<<<<<< " + key);
				for (int[] a : map)
					System.out.println(Arrays.toString(a));
			}
		}
	}
}