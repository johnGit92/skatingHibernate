package model;

public enum Disciplina {

	LATIN(1),
	POPDANCE(2),
	HIPHOP(3);
	
	private final int val;
	
	Disciplina(int val){
		this.val=val;
	}
	
	public int getVal() {
		return val;
	}
}
