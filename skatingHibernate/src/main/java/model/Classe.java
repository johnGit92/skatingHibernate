package model;

public enum Classe {

	LS(1),
	GS(2);
	
	private final int val;
	
	Classe(int val){
		this.val=val;
	}
	
	public int getVal() {
		return val;
	}
}
