package br.org.mcord.famec.constants;

public enum PermissaoEnum {
	
	ADMIN(1), ESCRITA(2), LEITURA(3);
	
	private final int valor;
	
	PermissaoEnum(int valor) {
		this.valor = valor;
	}

	public int getValor(){
        return valor;
    }
}
