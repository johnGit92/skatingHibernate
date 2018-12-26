package model;

public enum Gruppo {

	PG(1),
	GG(2);
	
	private final int val;
	
	Gruppo(int val){
		this.val=val;
	}

	public int getVal() {
		return val;
	}
	
}
