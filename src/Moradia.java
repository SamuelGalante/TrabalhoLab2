
public enum Moradia {
	RURAL("Rural"), URBANA("Urbana");

	String valor;
	Moradia(String valor) {
		this.valor = valor;
	}
	
	String getValor() {
		return valor;
	}
}
