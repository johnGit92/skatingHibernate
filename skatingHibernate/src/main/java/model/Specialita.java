package model;

public enum Specialita {
	
	SINCRO(1),
	COREOGRAPHIC(2),
	SHOW(3);
	
	private final int val;
	
	Specialita(int val){
		this.val=val;
	}
	
	public int getVal() {
		return val;
	}
}
