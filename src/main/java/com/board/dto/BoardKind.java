package com.board.dto;

public enum BoardKind {
	FreeBoard(1),
	MemberBoard(2),
	AdminBoard(3);
	
	private final int kind;
	
	BoardKind(int kind){
		this.kind = kind;
	}
	
	public int getKind() {
		return kind;
	}
	public static BoardKind valueOf(int kind) {
		switch(kind) {
		case 1: 
			return FreeBoard;
		case 2: 
			return MemberBoard;
		case 3: 
			return AdminBoard;
		default :
			throw new AssertionError("Unknown kind" + kind);
		}
	}
}
