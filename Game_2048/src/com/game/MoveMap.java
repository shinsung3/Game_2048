package com.game;

public class MoveMap {
	private int row; // 0
	private int col; // 0
	private int value; // 0
	private boolean checked; // false

	// ��ǥ�� ����� (row, col)
	public MoveMap(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	// value�� ��� �ִ� constructor (row, col, value, ������ ����.)
	public MoveMap(int row, int col, int value, boolean checked) {
		super();
		this.row = row;
		this.col = col;
		this.value = value;
		this.checked = checked;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "MoveMap [row=" + row + ", col=" + col + ", value=" + value + ", checked=" + checked + "]";
	}

}