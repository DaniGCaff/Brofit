package model;

public enum TamanoGMuscular {
	
	MUY_GRANDE(1),
	GRANDE(2),
	MEDIANO(3),
	NEUTRO(4),
	PEQUE�O(5),
	MUY_PEQUE�O(6);
	
	public int valor;
	
	TamanoGMuscular(int valor) {
		this.valor = valor;
	}
}
