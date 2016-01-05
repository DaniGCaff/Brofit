package model;

public enum TamanoGMuscular {
	
	MUY_GRANDE(1),
	GRANDE(2),
	MEDIANO(3),
	NEUTRO(4),
	PEQUEÑO(5),
	MUY_PEQUEÑO(6);
	
	public int valor;
	
	TamanoGMuscular(int valor) {
		this.valor = valor;
	}
}
