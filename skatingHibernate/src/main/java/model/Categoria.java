package model;

public enum Categoria {

	U5(1),
	U7(2),
	U9(3),
	U11(4),
	U13(5),
	U16(6),
	U21(7),
	O16(8),
	O35(9),
	O50(10),
	OPEN(11);
	
	private final int val;
	
	Categoria(int val){
		this.val=val;
	}
	
	public int getVal() {
		return val;
	}
}
