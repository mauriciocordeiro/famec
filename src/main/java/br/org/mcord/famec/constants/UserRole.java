package br.org.mcord.famec.constants;

public enum UserRole {
	
	ADMIN("ADMIN"), USER("USER");

	private final String value;
	
	UserRole(String value) {
		this.value = value;
	}
	
	public String get() {
		return value;
	}
}
