package model;

public enum TrenCorporal {
	
	SUPERIOR(1),
	NEUTRO(2),
	INFERIOR(3);
	
	public int valor;
	
	TrenCorporal(int valor) {
		this.valor = valor;
	}
}
